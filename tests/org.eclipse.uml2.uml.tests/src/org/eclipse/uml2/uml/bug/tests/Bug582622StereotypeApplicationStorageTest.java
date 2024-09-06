/*
 * Copyright (c) 2023-2024 Eike Stepper (Loehne, Germany), CEA, and others..
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   Eike Stepper - initial API and implementation
 *   Pauline Deville (CEA) - 13
 */
package org.eclipse.uml2.uml.bug.tests;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;
import org.eclipse.uml2.uml.Stereotype;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.uml2.uml.tests.util.StandaloneSupport;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.eclipse.uml2.uml.util.UMLUtil.StereotypeApplicationStorage;
import org.eclipse.uml2.uml.util.UMLUtil.StereotypeApplicationStorage.ContainedByElement;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class Bug582622StereotypeApplicationStorageTest
		extends TestCase {

	private ResourceSet rset;

	private Element fixture;

	private Profile profile;

	private Stereotype stereoClass;

	private Stereotype stereoPackage;

	public Bug582622StereotypeApplicationStorageTest() {
		super();
	}

	public Bug582622StereotypeApplicationStorageTest(String name) {
		super(name);
	}

	public static Test suite() {
		return new TestSuite(Bug582622StereotypeApplicationStorageTest.class, "Bug 582622 tests for Stereotype Application Storages");
	}

	/**
	 * Returns the default / location-based URI fragment of the given
	 * <code>eObject</code>.
	 * <p>
	 * <b>Implementation note:</b> Requires the given <code>eObject</code> to be
	 * contained in an XMLResource, so that that resource's
	 * {@link XMLResource#getEObjectToIDMap() ID map} can be temporarily
	 * cleared. This is necessary to get the result of
	 * {@link ResourceImpl#getURIFragment(EObject)}.
	 */
	protected static String getURIFragment(EObject eObject) {
		XMLResource resource = (XMLResource) eObject.eResource();
		if (resource == null) {
			return null;
		}

		@SuppressWarnings("deprecation")
		Map<EObject, String> idMap = resource.getEObjectToIDMap();
		Map<EObject, String> backupMap = new HashMap<EObject, String>(idMap);
		idMap.clear();

		try {
			return resource.getURIFragment(eObject);
		} finally {
			idMap.putAll(backupMap);
		}
	}

	protected static void assertURIFragment(String fragment, EObject eObject) {
		assertEquals(fragment, getURIFragment(eObject));
	}

	protected Class getMetaclass(String name) {
		Resource res = rset
			.getResource(URI.createURI(UMLResource.UML_METAMODEL_URI), true);
		assertNotNull("Could not find UML metamodel", res);
		assertTrue("Could not load UML metamodel", res.isLoaded());

		Package uml = (Package) EcoreUtil.getObjectByType(res.getContents(),
			UMLPackage.Literals.PACKAGE);
		assertNotNull(uml);

		return (Class) uml.getOwnedType(name);
	}

	@Override
	protected void setUp()
			throws Exception {

		UMLUtil.setStereotypeApplicationStorageEnabled(true);
		
		rset = new ResourceSetImpl();
		if (StandaloneSupport.isStandalone()) {
			StandaloneSupport.init(rset);
			rset.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("xmi", new XMIResourceFactoryImpl());

			StereotypeApplicationStorage testStorage = new TestStorage();
			StereotypeApplicationStorage.Registry.INSTANCE
				.put(testStorage.getID(), testStorage);
		}

		Resource res = rset.createResource(
			URI.createURI("StereotypeApplicationStorageTest.uml"));

		Package pkg = UMLFactory.eINSTANCE.createPackage();
		pkg.setName("pkg");
		res.getContents().add(pkg);

		fixture = pkg.createOwnedClass("Foo", false);

		profile = UMLFactory.eINSTANCE.createProfile();
		profile.setName("profile");
		profile.setURI("http://www.eclipse.org/bogus/schema/2013/profile");
		res.getContents().add(profile);

		Class metaclassClass = getMetaclass("Class");
		profile.createMetaclassReference(metaclassClass);
		stereoClass = profile.createOwnedStereotype("test_Class", false);
		stereoClass.createExtension(metaclassClass, false);

		Class metaclassPackage = getMetaclass("Package");
		profile.createMetaclassReference(metaclassPackage);
		stereoPackage = profile.createOwnedStereotype("test_Package", false);
		stereoPackage.createExtension(metaclassPackage, false);

		profile.define();
		pkg.applyProfile(profile);
	}

	@Override
	protected void tearDown()
			throws Exception {

		// Clean up the CacheAdapter as well as we can.
		for (Resource next : rset.getResources()) {
			next.unload();
			next.eAdapters().clear();
		}

		rset.getResources().clear();
		rset.eAdapters().clear();
		
		UMLUtil.setStereotypeApplicationStorageEnabled(false);
	}

	public void test_Registry() {
		Set<String> ids = StereotypeApplicationStorage.Registry.INSTANCE
			.keySet();
		assertTrue(ids.contains(ContainedByElement.INSTANCE.getID()));
		assertTrue(ids.contains(TestStorage.ID));
	}

	public void test_applyAndUnapplyStereotype() {

		// 1) Activate the "ContainedByElement" StereotypeApplicationStorage.
		// Verify that the StereotypeApplicationStorage is "ContainedByElement".

		UMLUtil.setStereotypeApplicationStorage(fixture,
			ContainedByElement.INSTANCE);

		StereotypeApplicationStorage storage1 = UMLUtil
			.getStereotypeApplicationStorage(fixture);
		assertSame(ContainedByElement.INSTANCE, storage1);

		// 2) Apply the stereotype. Verify that the SA is stored in the
		// "StereotypeApplications" EAnnotation below the element.

		EObject application = fixture.applyStereotype(stereoClass);
		assertTrue(fixture.isStereotypeApplied(stereoClass));
		assertURIFragment(
			"/0/Foo/%http:%2F%2Fwww.eclipse.org%2Fuml2%2FStereotypeApplications%/@contents.0",
			application);
		assertEquals(2, fixture.eResource().getContents().size());

		// 3) Unapply the stereotype. Verify that the SA is deleted.

		fixture.unapplyStereotype(stereoClass);
		assertFalse(fixture.isStereotypeApplied(stereoClass));
		assertURIFragment(null, application);
	}

	public void test_applyAndUnapplyStereotype__TestStorage() {

		// 1) Activate the "TestStorage" StereotypeApplicationStorage.
		// Verify that the StereotypeApplicationStorage is "TestStorage".

		StereotypeApplicationStorage testStorage = UMLUtil
			.setStereotypeApplicationStorageID(fixture, TestStorage.ID);

		StereotypeApplicationStorage storage1 = UMLUtil
			.getStereotypeApplicationStorage(fixture);
		assertSame(testStorage, storage1);

		// 2) Apply the stereotype. Verify that the SA is no longer stored in
		// the resource's contents list.

		EObject application = fixture.applyStereotype(stereoClass);
		assertTrue(fixture.isStereotypeApplied(stereoClass));
		assertURIFragment(null, application);
		assertEquals(2, fixture.eResource().getContents().size());

		// 3) Unapply the stereotype. Verify that the SA is deleted.

		fixture.unapplyStereotype(stereoClass);
		assertFalse(fixture.isStereotypeApplied(stereoClass));
		assertURIFragment(null, application);
	}

	public void test_migrateStereotypeApplications() {

		// 1) Apply the stereotype while no special SA Storage
		// is active. Verify that the SA is stored in the resource contents.

		EObject application = fixture.applyStereotype(stereoClass);
		assertTrue(fixture.isStereotypeApplied(stereoClass));
		assertURIFragment("/2", application);
		assertEquals(3, fixture.eResource().getContents().size());

		StereotypeApplicationStorage storage1 = UMLUtil
			.getStereotypeApplicationStorage(fixture);
		assertNull(storage1);

		// 2) Activate the "ContainedByElement" StereotypeApplicationStorage.
		// Verify that the SA is stored in the "StereotypeApplications"
		// EAnnotation below the element.

		UMLUtil.setStereotypeApplicationStorage(fixture,
			ContainedByElement.INSTANCE);
		assertTrue(fixture.isStereotypeApplied(stereoClass));
		assertURIFragment(
			"/0/Foo/%http:%2F%2Fwww.eclipse.org%2Fuml2%2FStereotypeApplications%/@contents.0",
			application);
		assertEquals(2, fixture.eResource().getContents().size());

		StereotypeApplicationStorage storage2 = UMLUtil
			.getStereotypeApplicationStorage(fixture);
		assertSame(ContainedByElement.INSTANCE, storage2);

		// 3) Deactivate the "ContainedByElement" StereotypeApplicationStorage.
		// Verify that the SA is stored in the resource contents.

		UMLUtil.setStereotypeApplicationStorage(fixture, null);
		assertTrue(fixture.isStereotypeApplied(stereoClass));
		assertURIFragment("/2", application);
		assertEquals(3, fixture.eResource().getContents().size());

		StereotypeApplicationStorage storage3 = UMLUtil
			.getStereotypeApplicationStorage(fixture);
		assertNull(storage3);
	}

	public void test_migrateStereotypeApplications__TestStorage() {
		// 1) Apply stereotypes while no special SA Storage
		// is active. Verify that the SA is stored in the resource contents.
		Element rootPackage = fixture.getOwner();
		assertTrue(rootPackage instanceof Package);
		EObject applicationRoot = rootPackage.applyStereotype(stereoPackage);
		assertURIFragment("/2", applicationRoot);

		EObject applicationFixture = fixture.applyStereotype(stereoClass);
		assertTrue(fixture.isStereotypeApplied(stereoClass));
		assertURIFragment("/3", applicationFixture);
		assertEquals(4, fixture.eResource().getContents().size());

		StereotypeApplicationStorage storage1 = UMLUtil
			.getStereotypeApplicationStorage(fixture);
		assertNull(storage1);

		// 2) Activate the "TestStorage" StereotypeApplicationStorage.
		// Verify that the SA is no longer stored in the resource's contents
		// list.

		StereotypeApplicationStorage testStorage = UMLUtil
			.setStereotypeApplicationStorageID(fixture, TestStorage.ID);
		assertTrue(fixture.isStereotypeApplied(stereoClass));
		assertURIFragment(null, applicationFixture);
		assertEquals(2, fixture.eResource().getContents().size());

		StereotypeApplicationStorage storage2 = UMLUtil
			.getStereotypeApplicationStorage(fixture);
		assertSame(testStorage, storage2);

		// 3) Deactivate the "TestStorage" StereotypeApplicationStorage.
		// Verify that the SA is stored in the resource contents.

		UMLUtil.setStereotypeApplicationStorage(fixture, null);
		assertTrue(rootPackage.isStereotypeApplied(stereoPackage));
		assertTrue(fixture.isStereotypeApplied(stereoClass));
		assertURIFragment("/2", applicationRoot);
		assertURIFragment("/3", applicationFixture);
		assertEquals(4, fixture.eResource().getContents().size());

		StereotypeApplicationStorage storage3 = UMLUtil
			.getStereotypeApplicationStorage(fixture);
		assertNull(storage3);
	}

	public static final class TestStorage
			implements StereotypeApplicationStorage {

		public static final String ID = "org.eclipse.uml2.uml.tests.TestStorage";

		private final Map<Element, EList<EObject>> stereotypeApplications = new HashMap<Element, EList<EObject>>();

		public TestStorage() {
		}

		public String getID() {
			return ID;
		}

		public String getName() {
			return "In Memory";
		}

		public String getDescription() {
			return "Stores stereotype applications in memory. Used for testing.";
		}

		public EList<EObject> getStereotypeApplications(Element element) {
			EList<EObject> list = stereotypeApplications.get(element);
			if (list != null) {
				return ECollections.unmodifiableEList(list);
			}

			return ECollections.emptyEList();
		}

		public void addStereotypeApplication(Element element,
				Stereotype stereotype, EObject stereotypeApplication) {
			EList<EObject> list = stereotypeApplications.get(element);
			if (list == null) {
				list = new BasicEList<EObject>();
				stereotypeApplications.put(element, list);
			}

			list.add(stereotypeApplication);
			EcoreUtil.remove(stereotypeApplication);
		}

		public void cleanup(Element element) {
			EList<EObject> list = stereotypeApplications.get(element);
			if (list != null) {
				for (Iterator<EObject> it = list.iterator(); it.hasNext();) {
					EObject stereotypeApplication = it.next();

					if (UMLUtil.getStereotype(stereotypeApplication) == null
							|| UMLUtil.getBaseElement(
								stereotypeApplication) == null) {
						it.remove();
					}
				}
			}
		}

		@Override
		public String toString() {
			return getID();
		}
	}
}

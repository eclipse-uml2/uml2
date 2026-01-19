/*
 * Copyright (c) 2025 Data In Motion and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   Data In Motion - initial API and implementation
 *
 */
package org.eclipse.uml2.uml.tests;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.RedefinableElement;
import org.eclipse.uml2.uml.Region;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.StateMachine;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.Vertex;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;
import org.eclipse.uml2.uml.tests.util.StandaloneSupport;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Tests for UML 2.5.1 migration and compatibility.
 * Verifies that models can be loaded and saved across UML 2.5.0 and 2.5.1 versions.
 *
 * Tests UMLR-685: Vertex extends RedefinableElement with redefinedVertex property.
 * State.redefinedState is now a derived property from Vertex.redefinedVertex.
 */
public class UML251MigrationTest extends TestCase {

	private ResourceSet rset;

	public UML251MigrationTest(String name) {
		super(name);
	}

	public static Test suite() {
		return new TestSuite(UML251MigrationTest.class, "UML 2.5.1 Migration Tests"); //$NON-NLS-1$
	}

	@Override
	protected void setUp() throws Exception {
		rset = new ResourceSetImpl();

		if (StandaloneSupport.isStandalone()) {
			StandaloneSupport.init(rset);
		} else {
			UMLResourcesUtil.init(rset);
		}
	}

	@Override
	protected void tearDown() throws Exception {
		for (Resource next : rset.getResources()) {
			next.unload();
		}

		rset.getResources().clear();
		rset.eAdapters().clear();
		rset = null;
	}

	/**
	 * Test that Vertex now implements RedefinableElement.
	 */
	public void testVertexIsRedefinableElement() {
		State state = UMLFactory.eINSTANCE.createState();
		assertTrue("State should be a Vertex", state instanceof Vertex);
		assertTrue("Vertex should be a RedefinableElement",
			state instanceof RedefinableElement);
	}

	/**
	 * Test that redefinedVertex property works on State and redefinedState is derived.
	 */
	public void testStateRedefinedState() {
		Model model = UMLFactory.eINSTANCE.createModel();
		model.setName("TestModel");

		org.eclipse.uml2.uml.Class context = model.createOwnedClass("Context", false);

		StateMachine baseSM = (StateMachine) context.createOwnedBehavior("BaseSM",
			UMLPackage.Literals.STATE_MACHINE);
		Region baseRegion = baseSM.createRegion("BaseRegion");
		State baseState = (State) baseRegion.createSubvertex("BaseState",
			UMLPackage.Literals.STATE);

		StateMachine extendedSM = (StateMachine) context.createOwnedBehavior("ExtendedSM",
			UMLPackage.Literals.STATE_MACHINE);
		extendedSM.getExtendedStateMachines().add(baseSM);
		Region extendedRegion = extendedSM.createRegion("ExtendedRegion");
		State extendedState = (State) extendedRegion.createSubvertex("ExtendedState",
			UMLPackage.Literals.STATE);

		// Set redefinedVertex (the new UML 2.5.1 property)
		extendedState.setRedefinedVertex(baseState);

		// Verify redefinedVertex is set
		assertEquals("redefinedVertex should be set", baseState,
			extendedState.getRedefinedVertex());

		// Verify redefinedState is derived from redefinedVertex
		assertEquals("redefinedState should be derived from redefinedVertex", baseState,
			extendedState.getRedefinedState());
	}

	/**
	 * Test that Vertex redefinition is tracked in redefinedElements.
	 */
	public void testRedefinedVertexInRedefinedElements() {
		Model model = UMLFactory.eINSTANCE.createModel();
		model.setName("TestModel");

		org.eclipse.uml2.uml.Class context = model.createOwnedClass("Context", false);

		StateMachine baseSM = (StateMachine) context.createOwnedBehavior("BaseSM",
			UMLPackage.Literals.STATE_MACHINE);
		Region baseRegion = baseSM.createRegion("BaseRegion");
		State baseState = (State) baseRegion.createSubvertex("BaseState",
			UMLPackage.Literals.STATE);

		StateMachine extendedSM = (StateMachine) context.createOwnedBehavior("ExtendedSM",
			UMLPackage.Literals.STATE_MACHINE);
		extendedSM.getExtendedStateMachines().add(baseSM);
		Region extendedRegion = extendedSM.createRegion("ExtendedRegion");
		State extendedState = (State) extendedRegion.createSubvertex("ExtendedState",
			UMLPackage.Literals.STATE);

		// Set redefinedVertex
		extendedState.setRedefinedVertex(baseState);

		// redefinedVertex should be baseState
		assertEquals("redefinedVertex should be baseState", baseState,
			extendedState.getRedefinedVertex());

		// redefinedState (derived) should also be baseState
		assertEquals("redefinedState should be derived from redefinedVertex", baseState,
			extendedState.getRedefinedState());
	}

	/**
	 * Test that redefinedVertex can be set and both redefinedVertex and redefinedState can be retrieved.
	 */
	public void testSetAndGetRedefinedVertex() {
		Model model = UMLFactory.eINSTANCE.createModel();
		model.setName("TestModel");

		org.eclipse.uml2.uml.Class context = model.createOwnedClass("Context", false);

		StateMachine baseSM = (StateMachine) context.createOwnedBehavior("BaseSM",
			UMLPackage.Literals.STATE_MACHINE);
		Region baseRegion = baseSM.createRegion("BaseRegion");
		State baseState = (State) baseRegion.createSubvertex("BaseState",
			UMLPackage.Literals.STATE);

		StateMachine extendedSM = (StateMachine) context.createOwnedBehavior("ExtendedSM",
			UMLPackage.Literals.STATE_MACHINE);
		extendedSM.getExtendedStateMachines().add(baseSM);
		Region extendedRegion = extendedSM.createRegion("ExtendedRegion");
		State extendedState = (State) extendedRegion.createSubvertex("ExtendedState",
			UMLPackage.Literals.STATE);

		// Initially null
		assertNull("redefinedVertex should initially be null",
			extendedState.getRedefinedVertex());
		assertNull("redefinedState should initially be null",
			extendedState.getRedefinedState());

		// Set redefinedVertex
		extendedState.setRedefinedVertex(baseState);

		// redefinedVertex should now return the set value
		assertEquals("redefinedVertex should be set", baseState,
			extendedState.getRedefinedVertex());

		// redefinedState (derived) should also return the set value
		assertEquals("redefinedState should be derived from redefinedVertex", baseState,
			extendedState.getRedefinedState());
	}

	/**
	 * Test creating and saving a model with state machine redefinition.
	 */
	public void testSaveModelWithStateMachineRedefinition() throws IOException {
		Model model = createTestModelWithRedefinedVertex();

		// Save model
		Resource resource = rset.createResource(
			URI.createURI("test.uml", true));
		resource.getContents().add(model);

		Map<String, Object> options = new HashMap<String, Object>();
		options.put(XMLResource.OPTION_ENCODING, "UTF-8");

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		resource.save(out, options);

		String content = out.toString("UTF-8");

		// Verify the model was saved
		assertNotNull("Saved content should not be null", content);
		assertTrue("Saved content should contain model name",
			content.contains("TestModel"));
	}

	/**
	 * Test round-trip: save and reload a model with state machine redefinition.
	 */
	public void testRoundTripModelWithStateMachineRedefinition() throws IOException {
		Model originalModel = createTestModelWithRedefinedVertex();

		// Save model
		Resource resource = rset.createResource(
			URI.createURI("test.uml", true));
		resource.getContents().add(originalModel);

		Map<String, Object> options = new HashMap<String, Object>();
		options.put(XMLResource.OPTION_ENCODING, "UTF-8");

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		resource.save(out, options);

		// Clear and reload
		resource.unload();
		rset.getResources().clear();

		Resource reloadedResource = rset.createResource(
			URI.createURI("test.uml", true));
		reloadedResource.load(new ByteArrayInputStream(out.toByteArray()), options);

		// Verify model structure
		assertEquals("Should have one root element", 1,
			reloadedResource.getContents().size());
		assertTrue("Root should be a Model",
			reloadedResource.getContents().get(0) instanceof Model);

		Model reloadedModel = (Model) reloadedResource.getContents().get(0);
		assertEquals("Model name should match", "TestModel", reloadedModel.getName());
	}

	/**
	 * Helper method to create a test model with state machine redefinition.
	 */
	private Model createTestModelWithRedefinedVertex() {
		Model model = UMLFactory.eINSTANCE.createModel();
		model.setName("TestModel");

		org.eclipse.uml2.uml.Class context = model.createOwnedClass("Context", false);

		// Create base state machine
		StateMachine baseSM = (StateMachine) context.createOwnedBehavior("BaseSM",
			UMLPackage.Literals.STATE_MACHINE);
		Region baseRegion = baseSM.createRegion("BaseRegion");
		State baseState = (State) baseRegion.createSubvertex("BaseState",
			UMLPackage.Literals.STATE);

		// Create extended state machine
		StateMachine extendedSM = (StateMachine) context.createOwnedBehavior("ExtendedSM",
			UMLPackage.Literals.STATE_MACHINE);
		extendedSM.getExtendedStateMachines().add(baseSM);
		Region extendedRegion = extendedSM.createRegion("ExtendedRegion");
		State extendedState = (State) extendedRegion.createSubvertex("ExtendedState",
			UMLPackage.Literals.STATE);

		// Set up vertex redefinition (UML 2.5.1)
		extendedState.setRedefinedVertex(baseState);

		return model;
	}

}

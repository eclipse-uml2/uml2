/*
 * Copyright (c) 2005, 2018 IBM Corporation, CEA, and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   IBM - initial API and implementation
 *   Kenn Hussey (CEA) - 327039
 *   Kenn Hussey - 528762, 535301
 *
 */
package org.eclipse.uml2.uml.internal.resource;

import java.io.IOException;
import java.io.OutputStream;

import java.lang.reflect.InvocationTargetException;

import java.util.Map;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl.BinaryIO.Version;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl.EObjectOutputStream;

import org.eclipse.emf.ecore.xmi.XMLLoad;
import org.eclipse.emf.ecore.xmi.XMLSave;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.UMLResource;

/**
 * <!-- begin-user-doc -->
 * The <b>Resource </b> associated with the package.
 * <!-- end-user-doc -->
 * @see org.eclipse.uml2.uml.internal.resource.UMLResourceFactoryImpl
 * @generated
 */
public class UMLResourceImpl
		extends XMIResourceImpl
		implements UMLResource {

	protected static abstract class EStructuralFeatureWrapper
			implements EStructuralFeature.Internal {

		protected EStructuralFeature.Internal eStructuralFeature;

		protected EStructuralFeatureWrapper(
				EStructuralFeature.Internal eStructuralFeature) {
			this.eStructuralFeature = eStructuralFeature;
		}

		public boolean isTransient() {
			return eStructuralFeature.isTransient();
		}

		public void setTransient(boolean value) {
			eStructuralFeature.setTransient(value);
		}

		public boolean isVolatile() {
			return eStructuralFeature.isVolatile();
		}

		public void setVolatile(boolean value) {
			eStructuralFeature.setVolatile(value);
		}

		public boolean isChangeable() {
			return eStructuralFeature.isChangeable();
		}

		public void setChangeable(boolean value) {
			eStructuralFeature.setChangeable(value);
		}

		public String getDefaultValueLiteral() {
			return eStructuralFeature.getDefaultValueLiteral();
		}

		public void setDefaultValueLiteral(String value) {
			eStructuralFeature.setDefaultValueLiteral(value);
		}

		public Object getDefaultValue() {
			return eStructuralFeature.getDefaultValue();
		}

		public void setDefaultValue(Object value) {
			eStructuralFeature.setDefaultValue(value);
		}

		public boolean isUnsettable() {
			return eStructuralFeature.isUnsettable();
		}

		public void setUnsettable(boolean value) {
			eStructuralFeature.setUnsettable(value);
		}

		public boolean isDerived() {
			return eStructuralFeature.isDerived();
		}

		public void setDerived(boolean value) {
			eStructuralFeature.setDerived(value);
		}

		public EClass getEContainingClass() {
			return eStructuralFeature.getEContainingClass();
		}

		public int getFeatureID() {
			return eStructuralFeature.getFeatureID();
		}

		public Class<?> getContainerClass() {
			return eStructuralFeature.getContainerClass();
		}

		public boolean isOrdered() {
			return eStructuralFeature.isOrdered();
		}

		public void setOrdered(boolean value) {
			eStructuralFeature.setOrdered(value);
		}

		public boolean isUnique() {
			return eStructuralFeature.isUnique();
		}

		public void setUnique(boolean value) {
			eStructuralFeature.setUnique(value);
		}

		public int getLowerBound() {
			return eStructuralFeature.getLowerBound();
		}

		public void setLowerBound(int value) {
			eStructuralFeature.setLowerBound(value);
		}

		public int getUpperBound() {
			return eStructuralFeature.getUpperBound();
		}

		public void setUpperBound(int value) {
			eStructuralFeature.setUpperBound(value);
		}

		public boolean isMany() {
			return eStructuralFeature.isMany();
		}

		public boolean isRequired() {
			return eStructuralFeature.isRequired();
		}

		public EClassifier getEType() {
			return eStructuralFeature.getEType();
		}

		public void setEType(EClassifier value) {
			eStructuralFeature.setEType(value);
		}

		public EGenericType getEGenericType() {
			return eStructuralFeature.getEGenericType();
		}

		public void setEGenericType(EGenericType value) {
			eStructuralFeature.setEGenericType(value);
		}

		public String getName() {
			return eStructuralFeature.getName();
		}

		public void setName(String value) {
			eStructuralFeature.setName(value);
		}

		public EList<EAnnotation> getEAnnotations() {
			return eStructuralFeature.getEAnnotations();
		}

		public EAnnotation getEAnnotation(String source) {
			return eStructuralFeature.getEAnnotation(source);
		}

		public EClass eClass() {
			return eStructuralFeature.eClass();
		}

		public Resource eResource() {
			return eStructuralFeature.eResource();
		}

		public EObject eContainer() {
			return eStructuralFeature.eContainer();
		}

		public EStructuralFeature eContainingFeature() {
			return eStructuralFeature.eContainingFeature();
		}

		public org.eclipse.emf.ecore.EReference eContainmentFeature() {
			return eStructuralFeature.eContainmentFeature();
		}

		public EList<EObject> eContents() {
			return eStructuralFeature.eContents();
		}

		public TreeIterator<EObject> eAllContents() {
			return eStructuralFeature.eAllContents();
		}

		public boolean eIsProxy() {
			return eStructuralFeature.eIsProxy();
		}

		public EList<EObject> eCrossReferences() {
			return eStructuralFeature.eCrossReferences();
		}

		public Object eGet(EStructuralFeature feature) {
			return eStructuralFeature.eGet(feature);
		}

		public Object eGet(EStructuralFeature feature, boolean resolve) {
			return eStructuralFeature.eGet(feature, resolve);
		}

		public void eSet(EStructuralFeature feature, Object newValue) {
			eStructuralFeature.eSet(feature, newValue);
		}

		public boolean eIsSet(EStructuralFeature feature) {
			return eStructuralFeature.eIsSet(feature);
		}

		public void eUnset(EStructuralFeature feature) {
			eStructuralFeature.eUnset(feature);
		}

		public Object eInvoke(EOperation operation, EList<?> arguments)
				throws InvocationTargetException {
			return eStructuralFeature.eInvoke(operation, arguments);
		}

		public EList<Adapter> eAdapters() {
			return eStructuralFeature.eAdapters();
		}

		public boolean eDeliver() {
			return eStructuralFeature.eDeliver();
		}

		public void eSetDeliver(boolean deliver) {
			eStructuralFeature.eSetDeliver(deliver);
		}

		public void eNotify(Notification notification) {
			eStructuralFeature.eNotify(notification);
		}

		public boolean eNotificationRequired() {
			return eStructuralFeature.eNotificationRequired();
		}

		public String eURIFragmentSegment(EStructuralFeature eFeature,
				EObject eObject) {
			return eStructuralFeature.eURIFragmentSegment(eFeature, eObject);
		}

		public EObject eObjectForURIFragmentSegment(String uriFragmentSegment) {
			return eStructuralFeature
				.eObjectForURIFragmentSegment(uriFragmentSegment);
		}

		public void eSetClass(EClass eClass) {
			eStructuralFeature.eSetClass(eClass);
		}

		public Setting eSetting(EStructuralFeature feature) {
			return eStructuralFeature.eSetting(feature);
		}

		public int eBaseStructuralFeatureID(int derivedFeatureID,
				Class<?> baseClass) {
			return eStructuralFeature.eBaseStructuralFeatureID(derivedFeatureID,
				baseClass);
		}

		public int eContainerFeatureID() {
			return eStructuralFeature.eContainerFeatureID();
		}

		public int eDerivedStructuralFeatureID(int baseFeatureID,
				Class<?> baseClass) {
			return eStructuralFeature.eDerivedStructuralFeatureID(baseFeatureID,
				baseClass);
		}

		public int eDerivedOperationID(int baseOperationID,
				Class<?> baseClass) {
			return eStructuralFeature.eDerivedOperationID(baseOperationID,
				baseClass);
		}

		public NotificationChain eSetResource(
				org.eclipse.emf.ecore.resource.Resource.Internal resource,
				NotificationChain notifications) {
			return eStructuralFeature.eSetResource(resource, notifications);
		}

		public NotificationChain eInverseAdd(InternalEObject otherEnd,
				int featureID, Class<?> baseClass,
				NotificationChain notifications) {
			return eStructuralFeature.eInverseAdd(otherEnd, featureID,
				baseClass, notifications);
		}

		public NotificationChain eInverseRemove(InternalEObject otherEnd,
				int featureID, Class<?> baseClass,
				NotificationChain notifications) {
			return eStructuralFeature.eInverseRemove(otherEnd, featureID,
				baseClass, notifications);
		}

		public NotificationChain eBasicSetContainer(
				InternalEObject newContainer, int newContainerFeatureID,
				NotificationChain notifications) {
			return eStructuralFeature.eBasicSetContainer(newContainer,
				newContainerFeatureID, notifications);
		}

		public NotificationChain eBasicRemoveFromContainer(
				NotificationChain notifications) {
			return eStructuralFeature.eBasicRemoveFromContainer(notifications);
		}

		public URI eProxyURI() {
			return eStructuralFeature.eProxyURI();
		}

		public void eSetProxyURI(URI uri) {
			eStructuralFeature.eSetProxyURI(uri);
		}

		public EObject eResolveProxy(InternalEObject proxy) {
			return eStructuralFeature.eResolveProxy(proxy);
		}

		public InternalEObject eInternalContainer() {
			return eStructuralFeature.eInternalContainer();
		}

		public org.eclipse.emf.ecore.resource.Resource.Internal eInternalResource() {
			return eStructuralFeature.eInternalResource();
		}

		public org.eclipse.emf.ecore.resource.Resource.Internal eDirectResource() {
			return eStructuralFeature.eDirectResource();
		}

		public EStore eStore() {
			return eStructuralFeature.eStore();
		}

		public void eSetStore(EStore store) {
			eStructuralFeature.eSetStore(store);
		}

		public Object eGet(EStructuralFeature eFeature, boolean resolve,
				boolean coreType) {
			return eStructuralFeature.eGet(eFeature, resolve, coreType);
		}

		public Object eGet(int featureID, boolean resolve, boolean coreType) {
			return eStructuralFeature.eGet(featureID, resolve, coreType);
		}

		public void eSet(int featureID, Object newValue) {
			eStructuralFeature.eSet(featureID, newValue);
		}

		public void eUnset(int featureID) {
			eStructuralFeature.eUnset(featureID);
		}

		public boolean eIsSet(int featureID) {
			return eStructuralFeature.eIsSet(featureID);
		}

		public Object eInvoke(int operationID, EList<?> arguments)
				throws InvocationTargetException {
			return eStructuralFeature.eInvoke(operationID, arguments);
		}

		public SettingDelegate getSettingDelegate() {
			return eStructuralFeature.getSettingDelegate();
		}

		public void setSettingDelegate(SettingDelegate settingDelegate) {
			eStructuralFeature.setSettingDelegate(settingDelegate);
		}

		public boolean isFeatureMap() {
			return eStructuralFeature.isFeatureMap();
		}

		public org.eclipse.emf.ecore.util.FeatureMap.Entry.Internal getFeatureMapEntryPrototype() {
			return eStructuralFeature.getFeatureMapEntryPrototype();
		}

		public void setFeatureMapEntryPrototype(
				org.eclipse.emf.ecore.util.FeatureMap.Entry.Internal prototype) {
			eStructuralFeature.setFeatureMapEntryPrototype(prototype);
		}

		public boolean isID() {
			return eStructuralFeature.isID();
		}

		public boolean isResolveProxies() {
			return eStructuralFeature.isResolveProxies();
		}

		public boolean isContainer() {
			return eStructuralFeature.isContainer();
		}

		public boolean isContainment() {
			return eStructuralFeature.isContainment();
		}

		public org.eclipse.emf.ecore.EReference getEOpposite() {
			return eStructuralFeature.getEOpposite();
		}

	}

	protected static class EReferenceWrapper
			extends EStructuralFeatureWrapper
			implements EReference {

		protected EReferenceWrapper(EReference eReference) {
			super((EStructuralFeature.Internal) eReference);
		}

		protected EReference getEReference() {
			return (EReference) eStructuralFeature;
		}

		public void setContainment(boolean value) {
			getEReference().setContainment(value);
		}

		public void setResolveProxies(boolean value) {
			getEReference().setResolveProxies(value);
		}

		public void setEOpposite(EReference value) {
			getEReference().setEOpposite(value);
		}

		public EClass getEReferenceType() {
			return getEReference().getEReferenceType();
		}

		public EList<EAttribute> getEKeys() {
			return getEReference().getEKeys();
		}
	}
	
	/**
	 * Creates an instance of the resource.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param uri the URI of the new resource.
	 * @generated
	 */
	public UMLResourceImpl(URI uri) {
		super(uri);
	}

	@Override
	protected XMLLoad createXMLLoad() {
		return new UMLLoadImpl(createXMLHelper());
	}

	@Override
	protected XMLSave createXMLSave() {
		return new UMLSaveImpl(createXMLHelper());
	}

	@Override
	protected boolean useIDAttributes() {
		return false;
	}

	@Override
	protected boolean useUUIDs() {
		return true;
	}

	@Override
	protected EObjectOutputStream createEObjectOutputStream(
			OutputStream outputStream, Map<?, ?> options, Version version,
			final URIHandler uriHandler)
			throws IOException {
		return new EObjectOutputStream(outputStream, options, version) {

			@Override
			protected URI deresolve(URI uri) {
				return uriHandler == null
					? super.deresolve(uri)
					: uriHandler.deresolve(uri);
			}

			@Override
			protected EStructuralFeatureData createEStructuralFeatureData(
					EStructuralFeature.Internal eStructuralFeature) {

				if (eStructuralFeature == UMLPackage.Literals.ACTIVITY__GROUP
					|| eStructuralFeature == UMLPackage.Literals.ACTIVITY__NODE) {

					eStructuralFeature = new EReferenceWrapper(
						(EReference) eStructuralFeature) {

						public boolean isTransient() {
							return false;
						}
					};
				}

				return super.createEStructuralFeatureData(eStructuralFeature);
			}

		};
	}

} //UMLResourceImpl

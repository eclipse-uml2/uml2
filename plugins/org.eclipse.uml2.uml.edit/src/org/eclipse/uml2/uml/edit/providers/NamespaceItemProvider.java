/*
 * Copyright (c) 2005, 2016 IBM Corporation, Embarcadero Technologies, CEA, and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - initial API and implementation
 *   Kenn Hussey (Embarcadero Technologies) - 215418, 204200
 *   Kenn Hussey - 323181
 *   Kenn Hussey (CEA) - 327039, 418466, 414970, 370089, 464702
 *
 */
package org.eclipse.uml2.uml.edit.providers;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.uml2.common.edit.command.SubsetAddCommand;
import org.eclipse.uml2.common.edit.command.SubsetSupersetReplaceCommand;
import org.eclipse.uml2.common.edit.command.SubsetSupersetSetCommand;
import org.eclipse.uml2.common.edit.command.SupersetRemoveCommand;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * This is the item provider adapter for a {@link org.eclipse.uml2.uml.Namespace} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class NamespaceItemProvider
		extends NamedElementItemProvider {

	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamespaceItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addOwnedRulePropertyDescriptor(object);
			addElementImportPropertyDescriptor(object);
			addPackageImportPropertyDescriptor(object);
			addOwnedMemberPropertyDescriptor(object);
			addImportedMemberPropertyDescriptor(object);
			addMemberPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Element Import feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addElementImportPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory)
				.getRootAdapterFactory(),
			getResourceLocator(),
			getString("_UI_Namespace_elementImport_feature"), //$NON-NLS-1$
			getString("_UI_PropertyDescriptor_description", //$NON-NLS-1$
				"_UI_Namespace_elementImport_feature", "_UI_Namespace_type"), //$NON-NLS-1$ //$NON-NLS-2$
			UMLPackage.Literals.NAMESPACE__ELEMENT_IMPORT, true, false, true,
			null, null, null));
	}

	/**
	 * This adds a property descriptor for the Package Import feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPackageImportPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory)
				.getRootAdapterFactory(),
			getResourceLocator(),
			getString("_UI_Namespace_packageImport_feature"), //$NON-NLS-1$
			getString("_UI_PropertyDescriptor_description", //$NON-NLS-1$
				"_UI_Namespace_packageImport_feature", "_UI_Namespace_type"), //$NON-NLS-1$ //$NON-NLS-2$
			UMLPackage.Literals.NAMESPACE__PACKAGE_IMPORT, true, false, true,
			null, null, null));
	}

	/**
	 * This adds a property descriptor for the Owned Rule feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOwnedRulePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory)
				.getRootAdapterFactory(),
			getResourceLocator(), getString("_UI_Namespace_ownedRule_feature"), //$NON-NLS-1$
			getString("_UI_PropertyDescriptor_description", //$NON-NLS-1$
				"_UI_Namespace_ownedRule_feature", "_UI_Namespace_type"), //$NON-NLS-1$ //$NON-NLS-2$
			UMLPackage.Literals.NAMESPACE__OWNED_RULE, true, false, true, null,
			null, null));
	}

	/**
	 * This adds a property descriptor for the Member feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMemberPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory)
				.getRootAdapterFactory(),
			getResourceLocator(), getString("_UI_Namespace_member_feature"), //$NON-NLS-1$
			getString("_UI_PropertyDescriptor_description", //$NON-NLS-1$
				"_UI_Namespace_member_feature", "_UI_Namespace_type"), //$NON-NLS-1$ //$NON-NLS-2$
			UMLPackage.Literals.NAMESPACE__MEMBER, false, false, false, null,
			null, new String[]{"org.eclipse.ui.views.properties.expert" //$NON-NLS-1$
		}));
	}

	/**
	 * This adds a property descriptor for the Imported Member feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addImportedMemberPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory)
				.getRootAdapterFactory(),
			getResourceLocator(),
			getString("_UI_Namespace_importedMember_feature"), //$NON-NLS-1$
			getString("_UI_PropertyDescriptor_description", //$NON-NLS-1$
				"_UI_Namespace_importedMember_feature", "_UI_Namespace_type"), //$NON-NLS-1$ //$NON-NLS-2$
			UMLPackage.Literals.NAMESPACE__IMPORTED_MEMBER, false, false, false,
			null, null, new String[]{"org.eclipse.ui.views.properties.expert" //$NON-NLS-1$
		}));
	}

	/**
	 * This adds a property descriptor for the Owned Member feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOwnedMemberPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory)
				.getRootAdapterFactory(),
			getResourceLocator(),
			getString("_UI_Namespace_ownedMember_feature"), //$NON-NLS-1$
			getString("_UI_PropertyDescriptor_description", //$NON-NLS-1$
				"_UI_Namespace_ownedMember_feature", "_UI_Namespace_type"), //$NON-NLS-1$ //$NON-NLS-2$
			UMLPackage.Literals.NAMESPACE__OWNED_MEMBER, false, false, false,
			null, null, new String[]{"org.eclipse.ui.views.properties.expert" //$NON-NLS-1$
		}));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(
			Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures
				.add(UMLPackage.Literals.NAMESPACE__OWNED_ELEMENT_IMPORT);
			childrenFeatures
				.add(UMLPackage.Literals.NAMESPACE__OWNED_PACKAGE_IMPORT);
			childrenFeatures
				.add(UMLPackage.Literals.NAMESPACE__OWNED_CONSTRAINT);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean shouldComposeCreationImage() {
		return true;
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((Namespace) object).getName();
		return label == null || label.length() == 0
			? getString("_UI_Namespace_type") //$NON-NLS-1$
			:
			getString("_UI_Namespace_type") + " " + label; //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Namespace.class)) {
			case UMLPackage.NAMESPACE__OWNED_RULE :
			case UMLPackage.NAMESPACE__ELEMENT_IMPORT :
			case UMLPackage.NAMESPACE__PACKAGE_IMPORT :
				fireNotifyChanged(new ViewerNotification(notification,
					notification.getNotifier(), false, true));
				return;
			case UMLPackage.NAMESPACE__OWNED_ELEMENT_IMPORT :
			case UMLPackage.NAMESPACE__OWNED_PACKAGE_IMPORT :
			case UMLPackage.NAMESPACE__OWNED_CONSTRAINT :
				fireNotifyChanged(new ViewerNotification(notification,
					notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(
			Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.NAMESPACE__OWNED_ELEMENT_IMPORT,
			UMLFactory.eINSTANCE.createElementImport()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.NAMESPACE__OWNED_PACKAGE_IMPORT,
			UMLFactory.eINSTANCE.createPackageImport()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.NAMESPACE__OWNED_CONSTRAINT,
			UMLFactory.eINSTANCE.createConstraint()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.NAMESPACE__OWNED_CONSTRAINT,
			UMLFactory.eINSTANCE.createInteractionConstraint()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.NAMESPACE__OWNED_CONSTRAINT,
			UMLFactory.eINSTANCE.createIntervalConstraint()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.NAMESPACE__OWNED_CONSTRAINT,
			UMLFactory.eINSTANCE.createDurationConstraint()));

		newChildDescriptors.add(createChildParameter(
			UMLPackage.Literals.NAMESPACE__OWNED_CONSTRAINT,
			UMLFactory.eINSTANCE.createTimeConstraint()));
	}

	@Override
	protected Command createAddCommand(EditingDomain domain, EObject owner,
			EStructuralFeature feature, Collection<?> collection, int index) {
		if (feature == UMLPackage.Literals.NAMESPACE__OWNED_CONSTRAINT) {
			return new SubsetAddCommand(domain, owner, feature,
				new EStructuralFeature[]{
					UMLPackage.Literals.NAMESPACE__OWNED_RULE},
				collection, index);
		}
		if (feature == UMLPackage.Literals.NAMESPACE__OWNED_ELEMENT_IMPORT) {
			return new SubsetAddCommand(domain, owner, feature,
				new EStructuralFeature[]{
					UMLPackage.Literals.NAMESPACE__ELEMENT_IMPORT},
				collection, index);
		}
		if (feature == UMLPackage.Literals.NAMESPACE__OWNED_PACKAGE_IMPORT) {
			return new SubsetAddCommand(domain, owner, feature,
				new EStructuralFeature[]{
					UMLPackage.Literals.NAMESPACE__PACKAGE_IMPORT},
				collection, index);
		}
		return super.createAddCommand(domain, owner, feature, collection,
			index);
	}

	@Override
	protected Command createRemoveCommand(EditingDomain domain, EObject owner,
			EStructuralFeature feature, Collection<?> collection) {
		if (feature == UMLPackage.Literals.NAMESPACE__ELEMENT_IMPORT) {
			return new SupersetRemoveCommand(domain, owner, feature,
				new EStructuralFeature[]{
					UMLPackage.Literals.NAMESPACE__OWNED_ELEMENT_IMPORT},
				collection);
		}
		if (feature == UMLPackage.Literals.NAMESPACE__OWNED_RULE) {
			return new SupersetRemoveCommand(domain, owner, feature,
				new EStructuralFeature[]{
					UMLPackage.Literals.NAMESPACE__OWNED_CONSTRAINT},
				collection);
		}
		if (feature == UMLPackage.Literals.NAMESPACE__PACKAGE_IMPORT) {
			return new SupersetRemoveCommand(domain, owner, feature,
				new EStructuralFeature[]{
					UMLPackage.Literals.NAMESPACE__OWNED_PACKAGE_IMPORT},
				collection);
		}
		return super.createRemoveCommand(domain, owner, feature, collection);
	}

	@Override
	protected Command createReplaceCommand(EditingDomain domain, EObject owner,
			EStructuralFeature feature, Object value,
			Collection<?> collection) {
		if (feature == UMLPackage.Literals.NAMESPACE__OWNED_CONSTRAINT) {
			return new SubsetSupersetReplaceCommand(domain, owner, feature,
				new EStructuralFeature[]{
					UMLPackage.Literals.NAMESPACE__OWNED_RULE},
				null, value, collection);
		}
		if (feature == UMLPackage.Literals.NAMESPACE__OWNED_ELEMENT_IMPORT) {
			return new SubsetSupersetReplaceCommand(domain, owner, feature,
				new EStructuralFeature[]{
					UMLPackage.Literals.NAMESPACE__ELEMENT_IMPORT},
				null, value, collection);
		}
		if (feature == UMLPackage.Literals.NAMESPACE__OWNED_PACKAGE_IMPORT) {
			return new SubsetSupersetReplaceCommand(domain, owner, feature,
				new EStructuralFeature[]{
					UMLPackage.Literals.NAMESPACE__PACKAGE_IMPORT},
				null, value, collection);
		}
		if (feature == UMLPackage.Literals.NAMESPACE__ELEMENT_IMPORT) {
			return new SubsetSupersetReplaceCommand(domain, owner, feature,
				null,
				new EStructuralFeature[]{
					UMLPackage.Literals.NAMESPACE__OWNED_ELEMENT_IMPORT},
				value, collection);
		}
		if (feature == UMLPackage.Literals.NAMESPACE__OWNED_RULE) {
			return new SubsetSupersetReplaceCommand(domain, owner, feature,
				null,
				new EStructuralFeature[]{
					UMLPackage.Literals.NAMESPACE__OWNED_CONSTRAINT},
				value, collection);
		}
		if (feature == UMLPackage.Literals.NAMESPACE__PACKAGE_IMPORT) {
			return new SubsetSupersetReplaceCommand(domain, owner, feature,
				null,
				new EStructuralFeature[]{
					UMLPackage.Literals.NAMESPACE__OWNED_PACKAGE_IMPORT},
				value, collection);
		}
		return super.createReplaceCommand(domain, owner, feature, value,
			collection);
	}

	@Override
	protected Command createSetCommand(EditingDomain domain, EObject owner,
			EStructuralFeature feature, Object value) {
		if (feature == UMLPackage.Literals.NAMESPACE__OWNED_CONSTRAINT) {
			return new SubsetSupersetSetCommand(domain, owner, feature,
				new EStructuralFeature[]{
					UMLPackage.Literals.NAMESPACE__OWNED_RULE},
				null, value);
		}
		if (feature == UMLPackage.Literals.NAMESPACE__OWNED_ELEMENT_IMPORT) {
			return new SubsetSupersetSetCommand(domain, owner, feature,
				new EStructuralFeature[]{
					UMLPackage.Literals.NAMESPACE__ELEMENT_IMPORT},
				null, value);
		}
		if (feature == UMLPackage.Literals.NAMESPACE__OWNED_PACKAGE_IMPORT) {
			return new SubsetSupersetSetCommand(domain, owner, feature,
				new EStructuralFeature[]{
					UMLPackage.Literals.NAMESPACE__PACKAGE_IMPORT},
				null, value);
		}
		if (feature == UMLPackage.Literals.NAMESPACE__ELEMENT_IMPORT) {
			return new SubsetSupersetSetCommand(domain, owner, feature, null,
				new EStructuralFeature[]{
					UMLPackage.Literals.NAMESPACE__OWNED_ELEMENT_IMPORT},
				value);
		}
		if (feature == UMLPackage.Literals.NAMESPACE__OWNED_RULE) {
			return new SubsetSupersetSetCommand(domain, owner, feature, null,
				new EStructuralFeature[]{
					UMLPackage.Literals.NAMESPACE__OWNED_CONSTRAINT},
				value);
		}
		if (feature == UMLPackage.Literals.NAMESPACE__PACKAGE_IMPORT) {
			return new SubsetSupersetSetCommand(domain, owner, feature, null,
				new EStructuralFeature[]{
					UMLPackage.Literals.NAMESPACE__OWNED_PACKAGE_IMPORT},
				value);
		}
		return super.createSetCommand(domain, owner, feature, value);
	}

}
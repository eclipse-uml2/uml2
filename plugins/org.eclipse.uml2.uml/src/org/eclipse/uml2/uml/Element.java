/*
 * Copyright (c) 2005, 2019 IBM Corporation, Embarcadero Technologies, CEA, and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   IBM - initial API and implementation
 *   Kenn Hussey (Embarcadero Technologies) - 205188
 *   Kenn Hussey (CEA) - 327039, 418466, 451350
 *   Christian W. Damus (CEA) - 251963
 *   Kenn Hussey - 535301, 543231
 *
 */
package org.eclipse.uml2.uml;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * An Element is a constituent of a model. As such, it has the capability of owning other Elements.
 * <p>From package UML::CommonStructure.</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.uml2.uml.Element#getOwnedComments <em>Owned Comment</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Element#getOwnedElements <em>Owned Element</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.Element#getOwner <em>Owner</em>}</li>
 * </ul>
 *
 * @see org.eclipse.uml2.uml.UMLPackage#getElement()
 * @model abstract="true"
 * @generated
 */
public interface Element
		extends EModelElement {

	/**
	 * Returns the value of the '<em><b>Owned Element</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.Element}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.uml2.uml.Element#getOwner <em>Owner</em>}'.
	 * This feature is a derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Elements owned by this Element.
	 * <p>From package UML::CommonStructure.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Element</em>' reference list.
	 * @see org.eclipse.uml2.uml.UMLPackage#getElement_OwnedElement()
	 * @see org.eclipse.uml2.uml.Element#getOwner
	 * @model opposite="owner" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<Element> getOwnedElements();

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.uml2.uml.Element#getOwnedElements <em>Owned Element</em>}'.
	 * This feature is a derived union.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Element that owns this Element.
	 * <p>From package UML::CommonStructure.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owner</em>' reference.
	 * @see org.eclipse.uml2.uml.UMLPackage#getElement_Owner()
	 * @see org.eclipse.uml2.uml.Element#getOwnedElements
	 * @model opposite="ownedElement" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	Element getOwner();

	/**
	 * Returns the value of the '<em><b>Owned Comment</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.uml2.uml.Comment}.
	 * <p>
	 * This feature subsets the following features:
	 * </p>
	 * <ul>
	 *   <li>'{@link org.eclipse.uml2.uml.Element#getOwnedElements() <em>Owned Element</em>}'</li>
	 * </ul>
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The Comments owned by this Element.
	 * <p>From package UML::CommonStructure.</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Owned Comment</em>' containment reference list.
	 * @see org.eclipse.uml2.uml.UMLPackage#getElement_OwnedComment()
	 * @model containment="true" resolveProxies="true" ordered="false"
	 * @generated
	 */
	EList<Comment> getOwnedComments();

	/**
	 * Creates a new {@link org.eclipse.uml2.uml.Comment} and appends it to the '<em><b>Owned Comment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return The new {@link org.eclipse.uml2.uml.Comment}.
	 * @see #getOwnedComments()
	 * @generated
	 */
	Comment createOwnedComment();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * An element may not directly or indirectly own itself.
	 * not allOwnedElements()->includes(self)
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean validateNotOwnSelf(DiagnosticChain diagnostics,
			Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Elements that must be owned must have an owner.
	 * mustBeOwned() implies owner->notEmpty()
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean validateHasOwner(DiagnosticChain diagnostics,
			Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the stereotype applications for this element.
	 * <!-- end-model-doc -->
	 * @model kind="operation" ordered="false"
	 * @generated
	 */
	EList<EObject> getStereotypeApplications();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the application of the specified stereotype for this element, or null if no such stereotype application exists.
	 * @param stereotype The stereotype for which to retrieve an application.
	 * <!-- end-model-doc -->
	 * @model ordered="false" stereotypeRequired="true" stereotypeOrdered="false"
	 * @generated
	 */
	EObject getStereotypeApplication(Stereotype stereotype);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the stereotypes that are required for this element.
	 * <!-- end-model-doc -->
	 * @model kind="operation" ordered="false"
	 * @generated
	 */
	EList<Stereotype> getRequiredStereotypes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the stereotype with the specified qualified name that is required for this element, or null if no such stereotype is required.
	 * @param qualifiedName The qualified name of the required stereotype to retrieve.
	 * <!-- end-model-doc -->
	 * @model ordered="false" qualifiedNameDataType="org.eclipse.uml2.types.String" qualifiedNameRequired="true" qualifiedNameOrdered="false"
	 * @generated
	 */
	Stereotype getRequiredStereotype(String qualifiedName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the stereotypes that are applied to this element.
	 * <!-- end-model-doc -->
	 * @model kind="operation" ordered="false"
	 * @generated
	 */
	EList<Stereotype> getAppliedStereotypes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the stereotype with the specified qualified name that is applied to this element, or null if no such stereotype is  applied.
	 * @param qualifiedName The qualified name of the applied stereotype to retrieve.
	 * <!-- end-model-doc -->
	 * @model ordered="false" qualifiedNameDataType="org.eclipse.uml2.types.String" qualifiedNameRequired="true" qualifiedNameOrdered="false"
	 * @generated
	 */
	Stereotype getAppliedStereotype(String qualifiedName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the substereotypes of the specified stereotype that are applied to this element.
	 * @param stereotype The superstereotype of the applied substereotypes to retrieve.
	 * <!-- end-model-doc -->
	 * @model ordered="false" stereotypeRequired="true" stereotypeOrdered="false"
	 * @generated
	 */
	EList<Stereotype> getAppliedSubstereotypes(Stereotype stereotype);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the substereotype of the specified stereotype with the specified qualified name that is applied to this element, or null if no such stereotype is applied.
	 * @param stereotype The superstereotype of the applied substereotype to retrieve.
	 * @param qualifiedName The qualified name of the applied substereotype to retrieve.
	 * <!-- end-model-doc -->
	 * @model ordered="false" stereotypeRequired="true" stereotypeOrdered="false" qualifiedNameDataType="org.eclipse.uml2.types.String" qualifiedNameRequired="true" qualifiedNameOrdered="false"
	 * @generated
	 */
	Stereotype getAppliedSubstereotype(Stereotype stereotype,
			String qualifiedName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Determines whether this element has a (non-default) value for the property with the specified name in the specified stereotype.
	 * @param stereotype The stereotype for which to test the property.
	 * @param propertyName The name of the property in question.
	 * <!-- end-model-doc -->
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false" stereotypeRequired="true" stereotypeOrdered="false" propertyNameDataType="org.eclipse.uml2.types.String" propertyNameRequired="true" propertyNameOrdered="false"
	 * @generated
	 */
	boolean hasValue(Stereotype stereotype, String propertyName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the value of the property with the specified name in the specified stereotype for this element.
	 * @param stereotype The stereotype for which to retrieve the value.
	 * @param propertyName The name of the property whose value to retrieve.
	 * <!-- end-model-doc -->
	 * @model ordered="false" stereotypeRequired="true" stereotypeOrdered="false" propertyNameDataType="org.eclipse.uml2.types.String" propertyNameRequired="true" propertyNameOrdered="false"
	 * @generated
	 */
	Object getValue(Stereotype stereotype, String propertyName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Sets the value of the property with the specified name in the specified stereotype for this element.
	 * @param stereotype The stereotype for which to set the value.
	 * @param propertyName The name of the property whose value to set.
	 * @param newValue The new value for the property.
	 * <!-- end-model-doc -->
	 * @model stereotypeRequired="true" stereotypeOrdered="false" propertyNameDataType="org.eclipse.uml2.types.String" propertyNameRequired="true" propertyNameOrdered="false" newValueRequired="true" newValueOrdered="false"
	 * @generated
	 */
	void setValue(Stereotype stereotype, String propertyName, Object newValue);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Creates an annotation with the specified source and this element as its model element.
	 * @param source The source for the new annotation.
	 * <!-- end-model-doc -->
	 * @model required="true" ordered="false" sourceDataType="org.eclipse.uml2.types.String" sourceRequired="true" sourceOrdered="false"
	 * @generated
	 */
	EAnnotation createEAnnotation(String source);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the relationships in which this element is involved.
	 * <!-- end-model-doc -->
	 * @model kind="operation" ordered="false"
	 * @generated
	 */
	EList<Relationship> getRelationships();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the relationships of the specified type in which this element is involved.
	 * @param eClass The (meta)type of the relationships to retrieve.
	 * <!-- end-model-doc -->
	 * @model ordered="false" eClassRequired="true" eClassOrdered="false"
	 * @generated
	 */
	EList<Relationship> getRelationships(EClass eClass);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the directed relationships for which this element is a source.
	 * <!-- end-model-doc -->
	 * @model kind="operation" ordered="false"
	 * @generated
	 */
	EList<DirectedRelationship> getSourceDirectedRelationships();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the directed relationships of the specified type for which this element is a source.
	 * @param eClass The (meta)type of the directed relationships to retrieve.
	 * <!-- end-model-doc -->
	 * @model ordered="false" eClassRequired="true" eClassOrdered="false"
	 * @generated
	 */
	EList<DirectedRelationship> getSourceDirectedRelationships(EClass eClass);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the directed relationships for which this element is a target.
	 * <!-- end-model-doc -->
	 * @model kind="operation" ordered="false"
	 * @generated
	 */
	EList<DirectedRelationship> getTargetDirectedRelationships();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the directed relationships of the specified type for which this element is a target.
	 * @param eClass The (meta)type of the directed relationships to retrieve.
	 * <!-- end-model-doc -->
	 * @model ordered="false" eClassRequired="true" eClassOrdered="false"
	 * @generated
	 */
	EList<DirectedRelationship> getTargetDirectedRelationships(EClass eClass);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the keywords for this element.
	 * <!-- end-model-doc -->
	 * @model kind="operation" dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	EList<String> getKeywords();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Adds the specified keyword to this element.
	 * @param keyword The keyword to add.
	 * <!-- end-model-doc -->
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false" keywordDataType="org.eclipse.uml2.types.String" keywordRequired="true" keywordOrdered="false"
	 * @generated
	 */
	boolean addKeyword(String keyword);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Removes the specified keyword from this element.
	 * @param keyword The keyword to remove.
	 * <!-- end-model-doc -->
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false" keywordDataType="org.eclipse.uml2.types.String" keywordRequired="true" keywordOrdered="false"
	 * @generated
	 */
	boolean removeKeyword(String keyword);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the nearest package that owns (either directly or indirectly) this element, or the element itself (if it is a package).
	 * <!-- end-model-doc -->
	 * @model kind="operation" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Package getNearestPackage();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the model that owns (either directly or indirectly) this element.
	 * <!-- end-model-doc -->
	 * @model kind="operation" ordered="false"
	 * @generated
	 */
	Model getModel();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Determines whether the specified stereotype is applicable to this element.
	 * @param stereotype The stereotype in question.
	 * <!-- end-model-doc -->
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false" stereotypeRequired="true" stereotypeOrdered="false"
	 * @generated
	 */
	boolean isStereotypeApplicable(Stereotype stereotype);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Determines whether the specified stereotype is required for this element.
	 * @param stereotype The stereotype in question.
	 * <!-- end-model-doc -->
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false" stereotypeRequired="true" stereotypeOrdered="false"
	 * @generated
	 */
	boolean isStereotypeRequired(Stereotype stereotype);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Determines whether the specified stereotype is applied to this element.
	 * @param stereotype The stereotype in question.
	 * <!-- end-model-doc -->
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false" stereotypeRequired="true" stereotypeOrdered="false"
	 * @generated
	 */
	boolean isStereotypeApplied(Stereotype stereotype);

	/**
	 * <!-- begin-user-doc -->
	 * This method returns an object that represents an application of the specified
	 * stereotype. By default, the object is attached to an appropriate resource
	 * relative to this element (e.g., the resource that this element is currently
	 * attached to, if any). Note, however, that <em><b>it is ultimately the caller’s
	 * responsibility to ensure that the stereotype application is attached to (and
	 * serialized with) the appropriate resource</b></em>.
	 * <br><br>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Applies the specified stereotype to this element.
	 * @param stereotype The stereotype to apply.
	 * <!-- end-model-doc -->
	 * @model required="true" ordered="false" stereotypeRequired="true" stereotypeOrdered="false"
	 * @generated
	 */
	EObject applyStereotype(Stereotype stereotype);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Unapplies the specified stereotype from this element.
	 * @param stereotype The stereotype to unapply.
	 * <!-- end-model-doc -->
	 * @model required="true" ordered="false" stereotypeRequired="true" stereotypeOrdered="false"
	 * @generated
	 */
	EObject unapplyStereotype(Stereotype stereotype);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the stereotypes that are applicable to this element, including those that are required and/or may already be applied.
	 * <!-- end-model-doc -->
	 * @model kind="operation" ordered="false"
	 * @generated
	 */
	EList<Stereotype> getApplicableStereotypes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Retrieves the stereotype with the specified qualified name that is applicable to this element, or null if no such stereotype is applicable.
	 * @param qualifiedName The qualified name of the applicable stereotype to retrieve.
	 * <!-- end-model-doc -->
	 * @model ordered="false" qualifiedNameDataType="org.eclipse.uml2.types.String" qualifiedNameRequired="true" qualifiedNameOrdered="false"
	 * @generated
	 */
	Stereotype getApplicableStereotype(String qualifiedName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Determines whether this element has the specified keyword.
	 * @param keyword The keyword in question.
	 * <!-- end-model-doc -->
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false" keywordDataType="org.eclipse.uml2.types.String" keywordRequired="true" keywordOrdered="false"
	 * @generated
	 */
	boolean hasKeyword(String keyword);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Destroys this element by removing all cross references to/from it and removing it from its containing resource or object.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	void destroy();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query allOwnedElements() gives all of the direct and indirect ownedElements of an Element.
	 * result = (ownedElement->union(ownedElement->collect(e | e.allOwnedElements()))->asSet())
	 * <p>From package UML::CommonStructure.</p>
	 * <!-- end-model-doc -->
	 * @model ordered="false"
	 * @generated
	 */
	EList<Element> allOwnedElements();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query mustBeOwned() indicates whether Elements of this type must have an owner. Subclasses of Element that do not require an owner must override this operation.
	 * result = (true)
	 * <p>From package UML::CommonStructure.</p>
	 * <!-- end-model-doc -->
	 * @model dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean mustBeOwned();

} // Element

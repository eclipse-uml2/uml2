/*
 * Copyright (c) 2014, 2018 CEA and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   Kenn Hussey (CEA) - initial API and implementation
 *   Kenn Hussey (CEA) - 451350
 *   Kenn Hussey - 535301
 *
 */
package org.eclipse.uml2.uml.profile.standard;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Model Library</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A package that contains model elements that are intended to be reused by other packages. It is analogous to a class library in some programming languages. The model library may not include instances of the metamodel extension metaclasses specified in Clause 12.3, such as Profiles and Stereotypes. However it may include ProfileApplications and Stereotype applications, and a model library is often used in conjunction with an applied Profile.
 * <p>From package StandardProfile (URI {@literal http://www.omg.org/spec/UML/20131001/StandardProfile}).</p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.uml2.uml.profile.standard.ModelLibrary#getBase_Package <em>Base Package</em>}</li>
 * </ul>
 *
 * @see org.eclipse.uml2.uml.profile.standard.StandardPackage#getModelLibrary()
 * @model
 * @generated
 */
public interface ModelLibrary
		extends EObject {

	/**
	 * Returns the value of the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>From package StandardProfile (URI {@literal http://www.omg.org/spec/UML/20131001/StandardProfile}).</p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Base Package</em>' reference.
	 * @see #setBase_Package(org.eclipse.uml2.uml.Package)
	 * @see org.eclipse.uml2.uml.profile.standard.StandardPackage#getModelLibrary_Base_Package()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Package getBase_Package();

	/**
	 * Sets the value of the '{@link org.eclipse.uml2.uml.profile.standard.ModelLibrary#getBase_Package <em>Base Package</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Package</em>' reference.
	 * @see #getBase_Package()
	 * @generated
	 */
	void setBase_Package(org.eclipse.uml2.uml.Package value);

} // ModelLibrary

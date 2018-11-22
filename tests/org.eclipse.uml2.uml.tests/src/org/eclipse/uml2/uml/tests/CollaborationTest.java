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
 *   Kenn Hussey - 535301
 *
 */
package org.eclipse.uml2.uml.tests;

import junit.textui.TestRunner;

import org.eclipse.uml2.uml.Collaboration;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Collaboration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following operations are tested:
 * <ul>
 *   <li>{@link org.eclipse.uml2.uml.BehavioredClassifier#validateClassBehavior(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Class Behavior</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.BehavioredClassifier#getAllImplementedInterfaces() <em>Get All Implemented Interfaces</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.BehavioredClassifier#getImplementedInterfaces() <em>Get Implemented Interfaces</em>}</li>
 * </ul>
 * </p>
 * @generated
 */
public class CollaborationTest
		extends StructuredClassifierTest {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(CollaborationTest.class);
	}

	/**
	 * Constructs a new Collaboration test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollaborationTest(String name) {
		super(name);
	}

	/**
	 * Returns the fixture for this Collaboration test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Collaboration getFixture() {
		return (Collaboration) fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	@Override
	protected void setUp()
			throws Exception {
		setFixture(UMLFactory.eINSTANCE.createCollaboration());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	@Override
	protected void tearDown()
			throws Exception {
		setFixture(null);
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.uml.BehavioredClassifier#validateClassBehavior(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Validate Class Behavior</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.BehavioredClassifier#validateClassBehavior(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	public void testValidateClassBehavior__DiagnosticChain_Map() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.uml.BehavioredClassifier#getAllImplementedInterfaces() <em>Get All Implemented Interfaces</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.BehavioredClassifier#getAllImplementedInterfaces()
	 * @generated
	 */
	public void testGetAllImplementedInterfaces() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

	/**
	 * Tests the '{@link org.eclipse.uml2.uml.BehavioredClassifier#getImplementedInterfaces() <em>Get Implemented Interfaces</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.uml2.uml.BehavioredClassifier#getImplementedInterfaces()
	 * @generated
	 */
	public void testGetImplementedInterfaces() {
		// TODO: implement this feature getter test method
		// Ensure that you remove @generated or mark it @generated NOT
	}

} //CollaborationTest

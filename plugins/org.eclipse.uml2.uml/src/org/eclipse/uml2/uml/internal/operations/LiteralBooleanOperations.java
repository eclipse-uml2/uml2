/*
 * Copyright (c) 2005, 2018 IBM Corporation, CEA, and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   IBM - initial API and implementation
 *   Kenn Hussey (CEA) - 327039, 418466, 451350
 *   Kenn Hussey - 535301
 *
 */
package org.eclipse.uml2.uml.internal.operations;

import org.eclipse.uml2.uml.LiteralBoolean;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Literal Boolean</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.uml2.uml.LiteralBoolean#stringValue() <em>String Value</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.LiteralBoolean#booleanValue() <em>Boolean Value</em>}</li>
 *   <li>{@link org.eclipse.uml2.uml.LiteralBoolean#isComputable() <em>Is Computable</em>}</li>
 * </ul>
 *
 * @generated
 */
public class LiteralBooleanOperations
		extends ValueSpecificationOperations {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LiteralBooleanOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query isComputable() is redefined to be true.
	 * result = (true)
	 * <p>From package UML::Values.</p>
	 * @param literalBoolean The receiving '<em><b>Literal Boolean</b></em>' model object.
	 * <!-- end-model-doc -->
	 * @generated NOT
	 */
	public static boolean isComputable(LiteralBoolean literalBoolean) {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The query booleanValue() gives the value.
	 * result = (value)
	 * <p>From package UML::Values.</p>
	 * @param literalBoolean The receiving '<em><b>Literal Boolean</b></em>' model object.
	 * <!-- end-model-doc -->
	 * @generated NOT
	 */
	public static boolean booleanValue(LiteralBoolean literalBoolean) {
		return literalBoolean.isValue();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static String stringValue(LiteralBoolean literalBoolean) {
		return String.valueOf(literalBoolean.booleanValue());
	}

} // LiteralBooleanOperations
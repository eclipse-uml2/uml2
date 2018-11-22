/*
 * Copyright (c) 2005, 2018 IBM Corporation, CEA, and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   IBM - initial API and implementation
 *   Kenn Hussey (CEA) - 418466, 451350
 *   Kenn Hussey - 535301
 *
 */
package org.eclipse.uml2.uml.internal.operations;

import org.eclipse.uml2.uml.Action;
import org.eclipse.uml2.uml.StructuredActivityNode;
import org.eclipse.uml2.uml.Variable;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Variable</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.uml2.uml.Variable#isAccessibleBy(org.eclipse.uml2.uml.Action) <em>Is Accessible By</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VariableOperations
		extends ConnectableElementOperations {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * A Variable is accessible by Actions within its scope (the Activity or StructuredActivityNode that owns it).
	 * result = (if scope<>null then scope.allOwnedNodes()->includes(a)
	 * else a.containingActivity()=activityScope
	 * endif)
	 * <p>From package UML::Activities.</p>
	 * @param variable The receiving '<em><b>Variable</b></em>' model object.
	 * <!-- end-model-doc -->
	 * @generated NOT
	 */
	public static boolean isAccessibleBy(Variable variable, Action a) {
		StructuredActivityNode scope = variable.getScope();

		return scope != null
			? scope.allOwnedNodes().contains(a)
			: a.containingActivity() == variable.getActivityScope();
	}

} // VariableOperations
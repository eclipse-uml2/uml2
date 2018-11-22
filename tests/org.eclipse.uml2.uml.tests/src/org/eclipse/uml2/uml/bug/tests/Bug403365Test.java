/*
 * Copyright (c) 2013, 2018 CEA and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   Kenn Hussey (CEA) - initial API and implementation
 *   Kenn Hussey - 535301
 */
package org.eclipse.uml2.uml.bug.tests;

import java.util.Collections;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.uml2.uml.Enumeration;
import org.eclipse.uml2.uml.EnumerationLiteral;
import org.eclipse.uml2.uml.UMLFactory;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class Bug403365Test
		extends TestCase {

	/**
	 * Initializes me with my name.
	 * 
	 * @param name
	 *            my name
	 */
	public Bug403365Test(String name) {
		super(name);
	}

	public static Test suite() {
		return new TestSuite(Bug403365Test.class, "Bug 403365 tests"); //$NON-NLS-1$
	}

	public void test_EcoreUtilCopyAll() {
		Enumeration enumeration = UMLFactory.eINSTANCE.createEnumeration();
		EnumerationLiteral enumerationLiteral = enumeration
			.createOwnedLiteral(getName());

		try {
			EcoreUtil.copyAll(Collections.singletonList(enumeration));
		} catch (UnsupportedOperationException uoe) {
			fail(uoe.getLocalizedMessage());
		}

		try {
			EcoreUtil.copyAll(Collections.singletonList(enumerationLiteral));
		} catch (UnsupportedOperationException uoe) {
			fail(uoe.getLocalizedMessage());
		}
	}

}

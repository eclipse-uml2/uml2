/*
 * Copyright (c) 2012, 2018 CEA and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   Christian W. Damus (CEA) - initial API and implementation
 *   Kenn Hussey - 535301
 */
package org.eclipse.uml2.uml.validation.tests;

import org.eclipse.emf.validation.model.IClientSelector;
import org.eclipse.uml2.uml.Element;

/**
 * A client-context selector that selects all UML elements while a test is
 * running.
 */
public class TestClientContextSelector
		implements IClientSelector {

	private static boolean on;

	/**
	 * Initializes me.
	 */
	public TestClientContextSelector() {
		super();
	}

	public boolean selects(Object object) {
		return on && (object instanceof Element);
	}

	static void turnOn() {
		on = true;
	}

	static void turnOff() {
		on = false;
	}
}

/*
 * Copyright (c) 2014, 2018 CEA and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   Kenn Hussey (CEA) - initial API and implementation
 *   Kenn Hussey - 535301
 *
 */
package org.eclipse.uml2.uml;

import org.eclipse.emf.common.util.EList;

/**
 * Common protocol for elements that own body (and language) strings.
 * 
 * @since 5.0
 */
public interface BodyOwner {

	/**
	 * Returns the value of the '<em><b>Body</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * 
	 * @return the value of the '<em>Body</em>' attribute list.
	 */
	EList<String> getBodies();

	/**
	 * Returns the value of the '<em><b>Language</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * 
	 * @return the value of the '<em>Language</em>' attribute list.
	 */
	EList<String> getLanguages();

}

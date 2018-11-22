/*
 * Copyright (c) 2011, 2018 CEA and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   Kenn Hussey (CEA) - initial API and implementation
 *   Kenn Hussey - 535301
 *
 */
package org.eclipse.uml2.uml.internal.resource;

import org.eclipse.uml2.uml.resource.UML302UMLResource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.xmi.XMLLoad;

public class UML302UMLResourceImpl
		extends UMLResourceImpl
		implements UML302UMLResource {

	public UML302UMLResourceImpl(URI uri) {
		super(uri);
	}

	@Override
	protected XMLLoad createXMLLoad() {
		return new UML302UMLLoadImpl(createXMLHelper());
	}

}

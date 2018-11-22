/*
 * Copyright (c) 2007, 2018 IBM Corporation, CEA, and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   Kenn Hussey (IBM Corporation) - initial API and implementation
 *   Kenn Hussey (CEA) - 327039
 *   Kenn Hussey - 535301
 *
 */
package org.eclipse.uml2.uml.internal.resource;

import org.eclipse.emf.ecore.xmi.XMLHelper;
import org.xml.sax.helpers.DefaultHandler;

public class CMOF202UMLLoadImpl
		extends UMLLoadImpl {

	public CMOF202UMLLoadImpl(XMLHelper helper) {
		super(helper);
	}

	@Override
	protected DefaultHandler makeDefaultHandler() {
		return new CMOF202UMLHandler(resource, helper, options);
	}

}

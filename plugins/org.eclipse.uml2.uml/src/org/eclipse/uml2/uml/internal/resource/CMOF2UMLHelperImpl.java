/*
 * Copyright (c) 2007, 2018 IBM Corporation, Embarcadero Technologies, and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   Kenn Hussey (IBM Corporation) - initial API and implementation
 *   Kenn Hussey (Embarcadero Technologies) - 218388
 *   Kenn Hussey - 535301
 *
 */
package org.eclipse.uml2.uml.internal.resource;

import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.resource.CMOF2UMLResource;

public class CMOF2UMLHelperImpl
		extends XMI2UMLHelperImpl {

	public CMOF2UMLHelperImpl(XMLResource resource) {
		super(resource);

		packages.put(UMLPackage.eINSTANCE,
			CMOF2UMLResource.CMOF_METAMODEL_NS_PREFIX);
	}

}

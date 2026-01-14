/*
 * Copyright (c) 2025 Data In Motion and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   Data In Motion - initial API and implementation
 *
 */
package org.eclipse.uml2.uml.resource;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.uml2.uml.internal.resource.UML510UMLResourceFactoryImpl;

/**
 * UML resource required for model migration.
 * OMG:  UML 2.5.1
 * API:  UML2 5.1
 *
 * @since 5.1
 */
public interface UML510UMLResource
		extends UMLResource {

	public interface Factory
			extends Resource.Factory {

		public static final Factory INSTANCE = new UML510UMLResourceFactoryImpl();
	}

	String UML_METAMODEL_NS_URI = "http://www.eclipse.org/uml2/5.1.0/UML"; //$NON-NLS-1$

	String UML_5_1_0_CONTENT_TYPE_IDENTIFIER = "org.eclipse.uml2.uml_5_1_0"; //$NON-NLS-1$

}

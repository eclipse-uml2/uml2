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
package org.eclipse.uml2.uml.internal.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.uml2.uml.resource.UML510UMLResource;

/**
 * Resource that converts .uml models.
 * OMG:  UML 2.5.1
 * API:  UML2 5.1
 *
 * @since 5.1
 */
public class UML510UMLResourceImpl
		extends UMLResourceImpl
		implements UML510UMLResource {

	public UML510UMLResourceImpl(URI uri) {
		super(uri);
	}

}

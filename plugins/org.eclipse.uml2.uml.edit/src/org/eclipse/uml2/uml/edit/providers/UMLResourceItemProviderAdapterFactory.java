/*
 * Copyright (c) 2006, 2018 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   IBM - initial API and implementation
 *   Kenn Hussey - 535301
 *
 */
package org.eclipse.uml2.uml.edit.providers;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;

public class UMLResourceItemProviderAdapterFactory
		extends ResourceItemProviderAdapterFactory {

	public UMLResourceItemProviderAdapterFactory() {
		super();
	}

	@Override
	public Adapter createResourceAdapter() {
		return new UMLResourceItemProvider(this);
	}

}

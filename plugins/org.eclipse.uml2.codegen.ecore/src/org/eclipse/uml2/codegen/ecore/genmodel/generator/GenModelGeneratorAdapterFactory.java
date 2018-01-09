/*
 * Copyright (c) 2006, 2018 IBM Corporation, CEA and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   IBM - initial API and implementation
 *   Sebastien Revol (CEA) - 529044
 *
 */
package org.eclipse.uml2.codegen.ecore.genmodel.generator;

import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.notify.Adapter;

/**
 * @since 1.2.0
 */
public class GenModelGeneratorAdapterFactory
		extends
		org.eclipse.emf.codegen.ecore.genmodel.generator.GenModelGeneratorAdapterFactory {

	@SuppressWarnings("deprecation")
	@Override
	protected String[] getTemplatePath(GenModel genModel) {
		return UML2GenModelGeneratorAdapterFactory.getUML2TemplatePath(super
			.getTemplatePath(genModel));
	}

	@Override
	public Adapter createGenClassAdapter() {

		if (genClassGeneratorAdapter == null) {
			genClassGeneratorAdapter = new GenClassGeneratorAdapter(this);
		}

		return genClassGeneratorAdapter;
	}

	@Override
	public Adapter createGenPackageAdapter() {

		if (genPackageGeneratorAdapter == null) {
			genPackageGeneratorAdapter = new GenPackageGeneratorAdapter(this);
		}

		return genPackageGeneratorAdapter;
	}

	
	@Override
	public Adapter createGenModelAdapter() {
		if (genModelGeneratorAdapter == null) {
			genModelGeneratorAdapter = new GenModelGeneratorAdapter(this);
		}
		
		return genModelGeneratorAdapter;
	}
}

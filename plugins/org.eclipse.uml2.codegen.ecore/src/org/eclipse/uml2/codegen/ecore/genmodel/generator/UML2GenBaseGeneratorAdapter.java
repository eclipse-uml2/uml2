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
package org.eclipse.uml2.codegen.ecore.genmodel.generator;

import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory;
import org.eclipse.emf.codegen.ecore.genmodel.generator.GenBaseGeneratorAdapter;
import org.eclipse.emf.codegen.jet.JETEmitter;
import org.eclipse.emf.codegen.jet.JETException;

/**
 * @since 1.2.0
 */
public class UML2GenBaseGeneratorAdapter
		extends GenBaseGeneratorAdapter {

	protected static void addUML2ClasspathEntries(JETEmitter jetEmitter)
			throws JETException {
		jetEmitter.addVariable("UML2_CODEGEN_ECORE", //$NON-NLS-1$
			"org.eclipse.uml2.codegen.ecore"); //$NON-NLS-1$
	}

	public UML2GenBaseGeneratorAdapter(
			GeneratorAdapterFactory generatorAdapterFactory) {
		super(generatorAdapterFactory);
	}

	@Override
	protected void addClasspathEntries(JETEmitter jetEmitter)
			throws JETException {
		super.addClasspathEntries(jetEmitter);

		addUML2ClasspathEntries(jetEmitter);
	}

}

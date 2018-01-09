/*
 * Copyright (c) 2018 CEA and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Sebastien Revol (CEA) - initial API and implementation
 *   Kenn Hussey - 529044
 *
 */
package org.eclipse.uml2.codegen.ecore.genmodel.generator;

import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.codegen.ecore.generator.GeneratorAdapterFactory;
import org.eclipse.emf.codegen.ecore.genmodel.GenModel;
import org.eclipse.emf.common.util.BasicMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.Monitor;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.uml2.codegen.ecore.genmodel.util.UML2GenModelUtil;
import org.eclipse.uml2.common.util.UML2Util;

public class GenModelGeneratorAdapter
		extends
		org.eclipse.emf.codegen.ecore.genmodel.generator.GenModelGeneratorAdapter {

	public GenModelGeneratorAdapter(
			GeneratorAdapterFactory generatorAdapterFactory) {
		super(generatorAdapterFactory);

	}

	@Override
	protected Diagnostic generateModel(Object object, Monitor monitor) {
		super.generateModel(object, monitor);

		GenModel genModel = (GenModel) object;

		if (!UML2Util.isEmpty(UML2GenModelUtil.getOperationsFolder(genModel))) {
			IPath operationsPath = new Path(
				UML2GenModelUtil.getOperationsPath(genModel));
			IWorkspace workspace = ResourcesPlugin.getWorkspace();
			IProject modelProject = workspace.getRoot()
				.getProject(operationsPath.segment(0));

			IJavaProject javaProject = JavaCore.create(modelProject);

			try {
				List<IClasspathEntry> classpathEntries = new UniqueEList<IClasspathEntry>() {

					private static final long serialVersionUID = 1L;

					@Override
					public boolean contains(Object object) {

						if (super.contains(object)) {
							return true;
						} else if (object instanceof IClasspathEntry) {
							IClasspathEntry classpathEntry = (IClasspathEntry) object;

							if (classpathEntry
								.getEntryKind() == IClasspathEntry.CPE_CONTAINER) {
								IPath path = classpathEntry.getPath();

								for (int i = 0; i < size; ++i) {
									IClasspathEntry otherClasspathEntry = get(
										i);

									if (otherClasspathEntry
										.getEntryKind() == IClasspathEntry.CPE_CONTAINER
										&& path.equals(
											otherClasspathEntry.getPath())) {

										return true;
									}
								}
							}
						}

						return false;
					}
				};

				classpathEntries
					.addAll(Arrays.asList(javaProject.getRawClasspath()));
				classpathEntries.add(JavaCore.newSourceEntry(operationsPath));

				javaProject.setRawClasspath(
					classpathEntries
						.toArray(new IClasspathEntry[classpathEntries.size()]),
					BasicMonitor.toIProgressMonitor(monitor));

			} catch (JavaModelException jme) {
				// should never happen hopefully...
			}
		}

		return Diagnostic.OK_INSTANCE;
	}
}

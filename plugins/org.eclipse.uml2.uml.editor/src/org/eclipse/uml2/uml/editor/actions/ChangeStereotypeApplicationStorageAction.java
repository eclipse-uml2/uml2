/*
 * Copyright (c) 2023 Eike Stepper (Loehne, Germany), CEA, and others..
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v2.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 *
 * Contributors:
 *   Eike Stepper - initial API and implementation
 */
package org.eclipse.uml2.uml.editor.actions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.IdentityCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.IAction;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.editor.UMLEditorPlugin;
import org.eclipse.uml2.uml.editor.dialogs.StereotypeApplicationStorageSelectionDialog;
import org.eclipse.uml2.uml.editor.dialogs.StereotypeApplicationStorageSelectionDialog.StorageInfo;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.eclipse.uml2.uml.util.UMLUtil.StereotypeApplicationStorage;

public class ChangeStereotypeApplicationStorageAction
		extends UMLCommandAction {

	public ChangeStereotypeApplicationStorageAction() {
		super();
	}

	@Override
	protected Command createActionCommand(EditingDomain editingDomain,
			Collection<?> collection) {

		if (collection.size() == 1
				&& collection.iterator().next() instanceof Element) {

			return IdentityCommand.INSTANCE;
		}

		return UnexecutableCommand.INSTANCE;
	}

	@Override
	public void run(IAction action) {

		if (command != UnexecutableCommand.INSTANCE) {
			final Element element = (Element) collection.iterator().next();

			List<StorageInfo> infos = new ArrayList<StorageInfo>();
			StorageInfo oldInfo = StorageInfo.collectFromRegistry(element,
				infos);

			StereotypeApplicationStorageSelectionDialog dialog = new StereotypeApplicationStorageSelectionDialog(
				workbenchPart.getSite().getShell(), infos, oldInfo);
			dialog.open();

			StorageInfo newInfo = dialog.getResultInfo();
			if (newInfo != null) {
				final StereotypeApplicationStorage newStorage = newInfo
					.getStorage();
				if (newStorage != oldInfo.getStorage()) {
					editingDomain.getCommandStack()
						.execute(new RefreshingChangeCommand(editingDomain,
							new Runnable() {

								public void run() {
									UMLUtil.setStereotypeApplicationStorage(
										element, newStorage);
								}
							}, UMLEditorPlugin.INSTANCE.getString(
								"_UI_ChangeStereotypeApplicationStorageAction_commandLabel"))); //$NON-NLS-1$
				}
			}
		}
	}
}

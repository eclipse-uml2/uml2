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
package org.eclipse.uml2.uml.editor.dialogs;

import java.util.Collections;
import java.util.List;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ListDialog;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.editor.UMLEditorPlugin;
import org.eclipse.uml2.uml.util.UMLUtil;
import org.eclipse.uml2.uml.util.UMLUtil.StereotypeApplicationStorage;

/**
 * A dialog that presents a {@link ListDialog list} of
 * {@link StereotypeApplicationStorage stereotype application storages}
 * represented by {@link StorageInfo storage info} objects and lets the user
 * select {@link #getResultInfo() one} of them.
 */
public class StereotypeApplicationStorageSelectionDialog
		extends ListDialog {

	private final StorageInfo initialInfo;

	/**
	 * Constructs a new {@link StereotypeApplicationStorageSelectionDialog
	 * dialog} object with the given title and message, with the given
	 * {@link StorageInfo storage infos} list, and the initial selection.
	 */
	public StereotypeApplicationStorageSelectionDialog(Shell shell,
			String title, String message, List<StorageInfo> infos,
			StorageInfo initialInfo) {
		super(shell);
		this.initialInfo = initialInfo;

		setTitle(title);
		setMessage(message);
		setContentProvider(new ArrayContentProvider());
		setLabelProvider(new LabelProvider());
		setInput(infos);
		setInitialSelections(initialInfo);
		setAddCancelButton(true);
		setHelpAvailable(false);
	}

	/**
	 * Constructs a new {@link StereotypeApplicationStorageSelectionDialog
	 * dialog} object with the default title and message, with the given
	 * {@link StorageInfo storage infos} list, and the initial selection.
	 */
	public StereotypeApplicationStorageSelectionDialog(Shell shell,
			List<StorageInfo> infos, StorageInfo initialInfo) {
		this(shell,
			UMLEditorPlugin.INSTANCE.getString(
				"_UI_ChangeStereotypeApplicationStorageAction_dialogTitle"), //$NON-NLS-1$
			UMLEditorPlugin.INSTANCE.getString(
				"_UI_ChangeStereotypeApplicationStorageAction_dialogMessage"), //$NON-NLS-1$
			infos, initialInfo);
	}

	public StorageInfo getInitialInfo() {
		return initialInfo;
	}

	public StorageInfo getResultInfo() {
		Object[] result = getResult();
		if (result != null && result.length == 1) {
			return (StorageInfo) result[0];
		}

		return null;
	}

	@Override
	protected Control createContents(Composite parent) {
		Control contents = super.createContents(parent);
		getOkButton().setEnabled(false);

		TableViewer tableViewer = getTableViewer();
		Composite area = tableViewer.getTable().getParent();

		GridData gd = new GridData(
			GridData.FILL_HORIZONTAL | GridData.VERTICAL_ALIGN_FILL);
		gd.heightHint = convertHeightInCharsToPixels(2);

		final Label descriptionLabel = new Label(area, SWT.WRAP);
		descriptionLabel.setLayoutData(gd);
		descriptionLabel.setFont(area.getFont());

		if (initialInfo != null) {
			descriptionLabel.setText(initialInfo.getDescription());
		}

		tableViewer
			.addSelectionChangedListener(new ISelectionChangedListener() {

				public void selectionChanged(SelectionChangedEvent event) {
					StorageInfo info = (StorageInfo) event
						.getStructuredSelection().getFirstElement();
					getOkButton().setEnabled(info != initialInfo);
					descriptionLabel.setText(info.getDescription());
				}
			});

		return contents;
	}

	@Override
	protected void okPressed() {
		if (getOkButton().isEnabled()) {
			super.okPressed();
		}
	}

	/**
	 * An immutable information object for a specific
	 * {@link StereotypeApplicationStorage stereotype application storage},
	 * capable of {@link #getStorage() providing} this storage from the
	 * {@link StereotypeApplicationStorage.Registry#INSTANCE storage registry}.
	 * <p>
	 * The implementations of {@link #hashCode()} and {@link #equals(Object)
	 * equals()} are based on the {@link #getID() ID} and
	 * {@link #compareTo(StorageInfo) compareTo()} is implemented
	 * {@link #getName() name}-based.
	 * <p>
	 * The associated stereotype application storage is <b>not</b> stored in
	 * this info object.
	 */
	public static final class StorageInfo
			implements Comparable<StorageInfo> {

		public static final StorageInfo DEFAULT = new StorageInfo(
			UMLEditorPlugin.INSTANCE.getString(
				"_UI_ChangeStereotypeApplicationStorageAction_defaultStorage_name"), //$NON-NLS-1$
			UMLEditorPlugin.INSTANCE.getString(
				"_UI_ChangeStereotypeApplicationStorageAction_defaultStorage_description")); //$NON-NLS-1$

		private final String id;

		private final String name;

		private final String description;

		/**
		 * Only called by the {@link #DEFAULT default storage info}, which
		 * requires the {@link #id} to be <code>null</code>.
		 */
		private StorageInfo(String name, String description) {
			this.id = null;
			this.name = name;
			this.description = description;
		}

		/**
		 * Creates a new {@link StorageInfo storage info} object and initializes
		 * it with the given <code>id</code>, <code>name</code>, and
		 * <code>description</code>.
		 * 
		 * @param id
		 *                        The {@link #getID() ID} of this
		 *                        {@link StorageInfo storage info} object, not
		 *                        <code>null</code>.
		 * @param name
		 *                        The {@link #getName() name} of this
		 *                        {@link StorageInfo storage info} object, can
		 *                        be <code>null</code> to indicate that
		 *                        {@link #getID() ID} is also to be used as the
		 *                        name.
		 * @param description
		 *                        The {@link #getDescription() description} of
		 *                        this {@link StorageInfo storage info} object,
		 *                        or <code>null</code> for an empty description.
		 */
		public StorageInfo(String id, String name, String description) {
			if (id == null) {
				throw new IllegalArgumentException("id"); //$NON-NLS-1$
			}

			this.id = id;
			this.name = name;
			this.description = description;
		}

		/**
		 * Returns the {@link StereotypeApplicationStorage#getID() ID} of this
		 * {@link StorageInfo storage info}, only <code>null</code> for the
		 * {@link #DEFAULT default storage info}.
		 */
		public String getID() {
			return id;
		}

		/**
		 * Returns the {@link StereotypeApplicationStorage#getName() name} of
		 * this {@link StorageInfo storage info}, or the {@link #getID() ID} if
		 * the name is <code>null</code>.
		 */
		public String getName() {
			return name == null
				? id
				: name;
		}

		/**
		 * Returns the {@link StereotypeApplicationStorage#getDescription()
		 * description} of this {@link StorageInfo storage info}, or an empty
		 * string if the description is <code>null</code>.
		 */
		public String getDescription() {
			return description == null
				? "" //$NON-NLS-1$
				: description;
		}

		/**
		 * Returns the {@link StereotypeApplicationStorage storage} of this
		 * storage info, or <code>null</code> if this storage info is the
		 * {@link #DEFAULT default storage info} or the {@link #getID() ID} of
		 * this storage info is currently not registered in the
		 * {@link StereotypeApplicationStorage.Registry#INSTANCE storage
		 * registry}.
		 */
		public StereotypeApplicationStorage getStorage() {
			if (id == null) {
				return null;
			}

			return StereotypeApplicationStorage.Registry.INSTANCE
				.getStereotypeApplicationStorage(id);
		}

		/**
		 * Returns a hash code based on the {@link #getID() ID} of this
		 * {@link StorageInfo storage info}.
		 */
		@Override
		public int hashCode() {
			return 31 + ((id == null)
				? 0
				: id.hashCode());
		}

		/**
		 * Indicates whether some other object is "equal to" this one based on
		 * the {@link #getID() ID} of this {@link StorageInfo storage info}.
		 */
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}

			if (obj == null) {
				return false;
			}

			if (getClass() != obj.getClass()) {
				return false;
			}

			StorageInfo other = (StorageInfo) obj;
			if (id == null) {
				if (other.id != null) {
					return false;
				}
			} else if (!id.equals(other.id)) {
				return false;
			}

			return true;
		}

		/**
		 * Establishes a natural ordering of {@link StorageInfo storage infos}
		 * based on the {@link #getName() names} of these infos.
		 */
		public int compareTo(StorageInfo o) {
			return getName().compareTo(o.getName());
		}

		/**
		 * Returns the {@link StereotypeApplicationStorage#getName() name} of
		 * this {@link StorageInfo storage info}, or the {@link #getID() ID} if
		 * the name is <code>null</code>.
		 * <p>
		 * Equivalent to calling {@link #getName()}.
		 */
		@Override
		public String toString() {
			return getName();
		}

		/**
		 * Collects a list of {@link StorageInfo info} objects for the
		 * {@link StereotypeApplicationStorage storages} currently registered in
		 * the {@link StereotypeApplicationStorage.Registry#INSTANCE storage
		 * registry} and returns the {@link StorageInfo info} object of the
		 * {@link StereotypeApplicationStorage storage} that is currently active
		 * for the outermost (top-level) package or model of the given UML
		 * <code>element</code>.
		 * <p>
		 * The <code>result</code> list will be sorted by
		 * {@link StorageInfo#getName() name} and contain the
		 * {@link StorageInfo#DEFAULT default storage info} as the first
		 * element. As a consequence the list will never be empty.
		 * 
		 * @param element
		 *                    A UML element that is used to determine the
		 *                    outermost (top-level) package or model.
		 * @param result
		 *                    A modifiable list to receive the
		 *                    {@link StorageInfo info} objects for the
		 *                    {@link StereotypeApplicationStorage storages}
		 *                    currently registered in the
		 *                    {@link StereotypeApplicationStorage.Registry#INSTANCE
		 *                    storage registry}.
		 * @return The {@link StorageInfo info} object of the
		 *         {@link StereotypeApplicationStorage storage} that is
		 *         currently active for the given UML <code>element</code>,
		 *         never <code>null</code>.
		 */
		public static StorageInfo collectFromRegistry(Element element,
				List<StorageInfo> result) {
			StereotypeApplicationStorage oldStorage = UMLUtil
				.getStereotypeApplicationStorage(element);
			StorageInfo oldInfo = StorageInfo.DEFAULT;

			for (Object value : StereotypeApplicationStorage.Registry.INSTANCE
				.values()) {
				StorageInfo info = null;
				if (value instanceof StereotypeApplicationStorage) {
					StereotypeApplicationStorage storage = (StereotypeApplicationStorage) value;
					info = new StorageInfo(storage.getID(), storage.getName(),
						storage.getDescription());

					if (storage == oldStorage) {
						oldInfo = info;
					}
				} else if (value instanceof StereotypeApplicationStorage.Descriptor) {
					StereotypeApplicationStorage.Descriptor descriptor = (StereotypeApplicationStorage.Descriptor) value;
					info = new StorageInfo(descriptor.getID(),
						descriptor.getName(), descriptor.getDescription());
				}

				if (info != null) {
					result.add(info);
				}
			}

			Collections.sort(result);
			result.add(0, StorageInfo.DEFAULT);
			return oldInfo;
		}
	}
}
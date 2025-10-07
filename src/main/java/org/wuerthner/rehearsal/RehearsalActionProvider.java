package org.wuerthner.rehearsal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import org.wuerthner.sport.action.*;
import org.wuerthner.sport.api.Action;
import org.wuerthner.sport.api.ActionProvider;

@Stateless
public class RehearsalActionProvider extends org.wuerthner.rehearsalmodel.action.RehearsalActionProvider implements ActionProvider {
	@Inject
	private AboutWebActionInterface aboutAction;
	
	@Inject
	private GenerateReportWebActionInterface generateReportAction;

	@Inject
	private GenerateModelReportWebActionInterface generateModelReportAction;

	@Inject
	private CollapseNavigationWebActionInterface collapseNavigationAction;
	
	@Inject
	private DeleteElementWebActionInterface deleteElementAction;
	
	@Inject
	private DumpWebActionInterface dumpAction;
	
	@Inject
	private ExportWebActionInterface exportAction;
	
	@Inject
	private ImportWebActionInterface importAction;
	
	@Inject
	private JournalWebActionInterface journalAction;
	
	@Inject
	private NewRootElementWebActionInterface newRootElementAction;
	
	@Inject
	private LogoutWebActionInterface logoutAction;
	
	@Inject
	private NewElementWebActionInterface newElementAction;
	
	@Inject
	private OpenDocumentWebActionInterface openDocumentAction;
	
	@Inject
	private SaveDocumentWebActionInterface saveDocumentAction;
	
	@Inject
	private RedoWebActionInterface redoAction;
	
	@Inject
	private UndoWebActionInterface undoAction;
	
	@Inject
	private ValidateWebActionInterface validateAction;
	
	@Inject
	private CompareWebActionInterface compareAction;
	
	@Inject
	private CutWebActionInterface cutAction;
	
	@Inject
	private CopyWebActionInterface copyAction;
	
	@Inject
	private PasteWebActionInterface pasteAction;
	
	@Inject
	private ClearWebActionInterface clearAction;
	
	@Override
	public List<Action> getActionList() {
		List<Action> actionList = new ArrayList<>();
		actionList.add(openDocumentAction);
		actionList.add(collapseNavigationAction);
		actionList.add(saveDocumentAction);
		actionList.add(newRootElementAction);
		actionList.add(newElementAction);
		actionList.add(deleteElementAction);
		
		actionList.add(new Separator());
		
		actionList.add(undoAction);
		actionList.add(redoAction);
		
		actionList.add(new Separator());
		
		actionList.add(cutAction);
		actionList.add(copyAction);
		actionList.add(pasteAction);
		actionList.add(clearAction);
		
		actionList.add(new Separator());
		
		actionList.add(importAction);
		actionList.add(exportAction);
		actionList.add(validateAction);
		actionList.add(compareAction);
		actionList.add(journalAction);
		// actionList.add(dumpAction);
		
		actionList.add(new Separator());
		
		// actionList.add(aboutAction);
		//actionList.add(generateModelReportAction);
		//actionList.add(generateReportAction);
		actionList.add(logoutAction);
		return actionList;
	}
	
	@Override
	public Optional<Action> getAction(String id) {
		Action result = null;
		for (Action action : getActionList()) {
			if (action.getId().equals(id)) {
				result = action;
				break;
			}
		}
		return Optional.ofNullable(result);
	}
}

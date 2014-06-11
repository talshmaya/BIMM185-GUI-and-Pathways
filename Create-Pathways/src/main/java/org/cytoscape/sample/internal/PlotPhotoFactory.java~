package org.cytoscape.sample.internal;

import org.cytoscape.model.CyNetworkFactory;
import org.cytoscape.model.CyNetworkManager;
import org.cytoscape.session.CyNetworkNaming;
import org.cytoscape.work.AbstractTaskFactory;
import org.cytoscape.work.TaskIterator;
import org.cytoscape.event.CyEventHelper;
import org.cytoscape.view.model.CyNetworkViewFactory;
import org.cytoscape.view.model.CyNetworkViewManager;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.vizmap.*;

public class PlotPhotoFactory extends AbstractTaskFactory {
	private final CyNetworkManager netMgr;
	private final CyNetworkFactory cnf;
	private final CyNetworkNaming namingUtil; 
	private  final CyEventHelper eventHelper;
	private CyNetworkViewFactory netViewFactory;
	private CyNetworkViewManager netViewMgr;
	private CyNetworkView netView;

	
	public PlotPhotoFactory(final CyNetworkManager netMgr, final CyNetworkNaming namingUtil, 
		final CyNetworkFactory cnf,final CyEventHelper eventHelper,CyNetworkViewFactory netViewFactory,CyNetworkViewManager netViewMgr,
		CyNetworkView netView){
		this.netMgr = netMgr;
		this.namingUtil = namingUtil;
		this.cnf = cnf;
		this.eventHelper=eventHelper;
		this.netViewMgr=netViewMgr;
		this.netViewFactory=netViewFactory;
		this.netView=netView;

	}
	
	public TaskIterator createTaskIterator(){
		return new TaskIterator(new PlotPhoto(netMgr, namingUtil, cnf, eventHelper,
			netViewFactory,netViewMgr,netView));
	}
}

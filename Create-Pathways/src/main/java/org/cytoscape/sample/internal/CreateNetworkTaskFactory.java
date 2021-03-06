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

public class CreateNetworkTaskFactory extends AbstractTaskFactory {
	private final CyNetworkManager netMgr;
	private final CyNetworkFactory cnf;
	private final CyNetworkNaming namingUtil; 
	private  final CyEventHelper eventHelper;
	private CyNetworkViewFactory netViewFactory;
	private CyNetworkViewManager netViewMgr;
	private CyNetworkView netView;

    private VisualMappingManager vmmServiceRef;
    private VisualStyleFactory visualStyleFactoryServiceRef;

    private VisualMappingFunctionFactory vmfFactoryC;
    private VisualMappingFunctionFactory vmfFactoryD;
    private VisualMappingFunctionFactory vmfFactoryP;

	
	public CreateNetworkTaskFactory(final CyNetworkManager netMgr, final CyNetworkNaming namingUtil, 
		final CyNetworkFactory cnf,final CyEventHelper eventHelper,CyNetworkViewFactory netViewFactory,CyNetworkViewManager netViewMgr,
		CyNetworkView netView, VisualMappingManager vmmServiceRef,VisualStyleFactory visualStyleFactoryServiceRef, VisualMappingFunctionFactory vmfFactoryC,VisualMappingFunctionFactory vmfFactoryD,VisualMappingFunctionFactory vmfFactoryP){
		this.netMgr = netMgr;
		this.namingUtil = namingUtil;
		this.cnf = cnf;
		this.eventHelper=eventHelper;
		this.netViewMgr=netViewMgr;
		this.netViewFactory=netViewFactory;
		this.netView=netView;

		this.vmmServiceRef = vmmServiceRef;
		this.visualStyleFactoryServiceRef=visualStyleFactoryServiceRef;
		this.vmfFactoryC=vmfFactoryC;
		this.vmfFactoryD=vmfFactoryD;
		this.vmfFactoryP=vmfFactoryP;
	}
	
	public TaskIterator createTaskIterator(){
		return new TaskIterator(new PlotGlycolysis(netMgr, namingUtil, cnf, eventHelper,
			netViewFactory,netViewMgr,netView, vmmServiceRef,visualStyleFactoryServiceRef,vmfFactoryC,vmfFactoryD,vmfFactoryP));
	}
}

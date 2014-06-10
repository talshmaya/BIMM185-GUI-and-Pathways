package org.cytoscape.sample.internal;

import org.cytoscape.model.CyNetworkFactory;
import org.cytoscape.session.CyNetworkNaming;
import org.cytoscape.model.CyNetworkManager;
import org.cytoscape.sample.internal.PlotGlycolysis;
import org.cytoscape.work.TaskFactory;
import org.osgi.framework.BundleContext;
import org.cytoscape.service.util.AbstractCyActivator;
import java.util.Properties;
import org.cytoscape.event.CyEventHelper;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.model.CyNetworkViewFactory;
import org.cytoscape.view.model.CyNetworkViewManager;
import org.cytoscape.view.vizmap.*;


public class CyActivator extends AbstractCyActivator {
	public CyActivator() {
		super();
	}


	public void start(BundleContext bc) {

		CyNetworkManager cyNetworkManagerServiceRef = getService(bc,CyNetworkManager.class);
		CyNetworkNaming cyNetworkNamingServiceRef = getService(bc,CyNetworkNaming.class);
		CyNetworkFactory cyNetworkFactoryServiceRef = getService(bc,CyNetworkFactory.class);
		CyEventHelper eventHelper = getService(bc, CyEventHelper.class);
		CyNetworkViewFactory netViewFactory = getService(bc, CyNetworkViewFactory.class);
		CyNetworkViewManager netViewMgr = getService(bc, CyNetworkViewManager.class);
		CyNetworkView netView = getService(bc, CyNetworkView.class);

        VisualMappingManager vmmServiceRef = getService(bc,VisualMappingManager.class);
        VisualStyleFactory visualStyleFactoryServiceRef = getService(bc,VisualStyleFactory.class);

        VisualMappingFunctionFactory vmfFactoryC = getService(bc,VisualMappingFunctionFactory.class, "(mapping.type=continuous)");
        VisualMappingFunctionFactory vmfFactoryD = getService(bc,VisualMappingFunctionFactory.class, "(mapping.type=discrete)");
        VisualMappingFunctionFactory vmfFactoryP = getService(bc,VisualMappingFunctionFactory.class, "(mapping.type=passthrough)");

		PlotGlycolysis plotGlycolysis = new PlotGlycolysis(cyNetworkManagerServiceRef,cyNetworkNamingServiceRef,
			cyNetworkFactoryServiceRef,eventHelper,netViewFactory,netViewMgr,netView,vmmServiceRef,visualStyleFactoryServiceRef,
			vmfFactoryC,vmfFactoryD,vmfFactoryP);		
		Properties sample05TaskFactoryProps = new Properties();
		sample05TaskFactoryProps.setProperty("preferredMenu","Apps.Maize App.Plot Pathways");
		sample05TaskFactoryProps.setProperty("title","Glycolysis I");
		registerService(bc,plotGlycolysis,TaskFactory.class, sample05TaskFactoryProps);

		//Properties TaskFactoryProps2 = new Properties();
		//TaskFactoryProps2.setProperty("preferredMenu","Apps.Maize App.Plot Pathways");
		//TaskFactoryProps2.setProperty("title","TCA Cycle");
		//registerService(bc,plotGlycolysis,TaskFactory.class, TaskFactoryProps2);
	}
}


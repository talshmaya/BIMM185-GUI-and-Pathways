package org.cytoscape.sample.internal;
import org.cytoscape.sample.internal.PlotGlycolysisFactory;
import org.cytoscape.sample.internal.PlotTCAFactory;
import org.cytoscape.sample.internal.PlotPhotoFactory;
import org.cytoscape.model.CyNetworkFactory;
import org.cytoscape.session.CyNetworkNaming;
import org.cytoscape.model.CyNetworkManager;
//import org.cytoscape.sample.internal.PlotGlycolysis;
import org.cytoscape.work.TaskFactory;
import org.osgi.framework.BundleContext;
import org.cytoscape.service.util.AbstractCyActivator;
import java.util.Properties;
import org.cytoscape.event.CyEventHelper;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.model.CyNetworkViewFactory;
import org.cytoscape.view.model.CyNetworkViewManager;
//import org.cytoscape.view.vizmap.*;
import org.cytoscape.view.layout.*;


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


		PlotGlycolysisFactory plotGlycolysisFactory1 = new PlotGlycolysisFactory(cyNetworkManagerServiceRef,cyNetworkNamingServiceRef,
			cyNetworkFactoryServiceRef,eventHelper,netViewFactory,netViewMgr,netView);		
		Properties sample05TaskFactoryProps = new Properties();
		sample05TaskFactoryProps.setProperty("preferredMenu","Apps.Maize App.Plot Pathways");
		sample05TaskFactoryProps.setProperty("title","Glycolysis I");
		registerService(bc,plotGlycolysisFactory1,TaskFactory.class, sample05TaskFactoryProps);


		PlotTCAFactory plotTCAFactory = new PlotTCAFactory(cyNetworkManagerServiceRef,cyNetworkNamingServiceRef,
			cyNetworkFactoryServiceRef,eventHelper,netViewFactory,netViewMgr,netView);		
		Properties sample06TaskFactoryProps = new Properties();
		sample06TaskFactoryProps.setProperty("preferredMenu","Apps.Maize App.Plot Pathways");
		sample06TaskFactoryProps.setProperty("title","TCA Cycle");
		registerService(bc,plotTCAFactory,TaskFactory.class, sample06TaskFactoryProps);


		PlotPhotoFactory plotPhotoFactory = new PlotPhotoFactory(cyNetworkManagerServiceRef,cyNetworkNamingServiceRef,
			cyNetworkFactoryServiceRef,eventHelper,netViewFactory,netViewMgr,netView);		
		Properties sample07TaskFactoryProps = new Properties();
		sample07TaskFactoryProps.setProperty("preferredMenu","Apps.Maize App.Plot Pathways");
		sample07TaskFactoryProps.setProperty("title","Photosynthesis");
		registerService(bc,plotPhotoFactory,TaskFactory.class, sample07TaskFactoryProps);

	}
}



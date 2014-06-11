package org.cytoscape.sample.internal;

import java.lang.Object;

import org.cytoscape.model.CyNetwork;
import org.cytoscape.model.CyNetworkFactory;
import org.cytoscape.model.CyNetworkManager;
import org.cytoscape.model.CyNode;
import org.cytoscape.session.CyNetworkNaming;
import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.TaskMonitor;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.model.View;
import org.cytoscape.event.CyEventHelper;
import org.cytoscape.view.model.CyNetworkViewFactory;
import org.cytoscape.view.model.CyNetworkViewManager;
import org.cytoscape.view.vizmap.*;

import org.cytoscape.view.layout.LayoutNode;
import org.cytoscape.view.vizmap.mappings.*;
import org.cytoscape.view.presentation.property.*;


public class PlotTCA extends AbstractTask {
	
	private final CyNetworkManager netMgr;
	private final CyNetworkFactory cnf;
	private final CyNetworkNaming namingUtil; 
	private final CyEventHelper eventHelper;
	private CyNetworkViewFactory netViewFactory;
	private CyNetworkViewManager netViewMgr;
	private CyNetworkView netView; 



	public PlotTCA(final CyNetworkManager netMgr, final CyNetworkNaming namingUtil,final CyNetworkFactory cnf,final CyEventHelper eventHelper,CyNetworkViewFactory netViewFactory,
                             CyNetworkViewManager netViewMgr,CyNetworkView netView){
		this.netMgr = netMgr;
		this.cnf = cnf;
		this.namingUtil = namingUtil;
		this.eventHelper=eventHelper;
		this.netViewFactory=netViewFactory;
		this.netViewMgr=netViewMgr;
		this.netView=netView;

	}
	
	public void run(TaskMonitor monitor) {
		// Create an empty network

		CyNetwork myNet = cnf.createNetwork();
		myNet.getRow(myNet).set(CyNetwork.NAME, 
				      namingUtil.getSuggestedNetworkTitle("TCA Cycle II"));
		netMgr.addNetwork(myNet);
		CyNetworkView netView = netViewFactory.createNetworkView(myNet);
		netViewMgr.addNetworkView(netView);

		// Add two nodes to the network
		CyNode oxaloacetate = myNet.addNode();
		CyNode citrate = myNet.addNode();
		CyNode cis_aconitate=myNet.addNode();

		CyNode D_threo_isocitrate=myNet.addNode();
		CyNode O2_oxoglutarate=myNet.addNode();
		CyNode succinyl_CoA=myNet.addNode();
		CyNode Succinate=myNet.addNode();

		CyNode Fumarate=myNet.addNode();
		CyNode  S_malate=myNet.addNode();
		//CyNode P2_phospho_D_glycerate=myNet.addNode();

		//CyNode newNode = myNet.addNode();

		// set name for new nodes
		myNet.getDefaultNodeTable().getRow(oxaloacetate.getSUID()).set("name", "Oxaloacetate");
		//myNet.getDefaultNodeTable().getRow(D_glucose_6_phosphate.getSUID()).set("ID", "12345");
		myNet.getDefaultNodeTable().getRow(citrate.getSUID()).set("name", "Citrate");
		myNet.getDefaultNodeTable().getRow(cis_aconitate.getSUID()).set("name","Cis-aconitate");

		myNet.getDefaultNodeTable().getRow(D_threo_isocitrate.getSUID()).set("name","D-threo-isocitrate");
		myNet.getDefaultNodeTable().getRow(O2_oxoglutarate.getSUID()).set("name","2-oxoglutarate");
		myNet.getDefaultNodeTable().getRow(succinyl_CoA.getSUID()).set("name","succinyl-CoA");
		myNet.getDefaultNodeTable().getRow(Succinate.getSUID()).set("name","Succinate");

		myNet.getDefaultNodeTable().getRow(Fumarate.getSUID()).set("name","Fumarate");
		myNet.getDefaultNodeTable().getRow( S_malate.getSUID()).set("name","(S)-malate");
		//myNet.getDefaultNodeTable().getRow(P2_phospho_D_glycerate.getSUID()).set("name","2-phospho-D-glycerate");

		// Add an edge
		myNet.addEdge(oxaloacetate, citrate,true);
		myNet.addEdge(citrate, cis_aconitate,false);
		myNet.addEdge(cis_aconitate,D_threo_isocitrate,false);
		myNet.addEdge(D_threo_isocitrate,O2_oxoglutarate,false);
		myNet.addEdge(O2_oxoglutarate,succinyl_CoA,true);
		myNet.addEdge(succinyl_CoA, Succinate,true);
		//myNet.addEdge(O2_oxoglutarate, D_threo_isocitrate,true);

		myNet.addEdge(Succinate,Fumarate,true);
		//myNet.addEdge(Succinate, P2_phospho_D_glycerate,true);
		myNet.addEdge(Fumarate,  S_malate,true);
		myNet.addEdge( S_malate,oxaloacetate, true);
		
		eventHelper.flushPayloadEvents();
		netViewMgr.addNetworkView(netView);
		View<CyNode> nodeview = netView.getNodeView(oxaloacetate);
        LayoutNode thelayoutnode = new LayoutNode(nodeview, 0, null);
        View<CyNode> nodeview2 = netView.getNodeView(citrate);
        LayoutNode thelayoutnode2 = new LayoutNode(nodeview2, 0, null);
        View<CyNode> nodeview3 = netView.getNodeView(cis_aconitate);
        LayoutNode thelayoutnode3 = new LayoutNode(nodeview3, 0, null);
        View<CyNode> nodeview4 = netView.getNodeView(D_threo_isocitrate);
        LayoutNode thelayoutnode4 = new LayoutNode(nodeview4, 0, null);
        View<CyNode> nodeview5 = netView.getNodeView(O2_oxoglutarate);
        LayoutNode thelayoutnode5 = new LayoutNode(nodeview5, 0, null);
        View<CyNode> nodeview6 = netView.getNodeView(succinyl_CoA);
        LayoutNode thelayoutnode6 = new LayoutNode(nodeview6, 0, null);
        View<CyNode> nodeview7 = netView.getNodeView(Succinate);
        LayoutNode thelayoutnode7 = new LayoutNode(nodeview7, 0, null);
        //View<CyNode> nodeview8 = netView.getNodeView(P2_phospho_D_glycerate);
        //LayoutNode thelayoutnode8 = new LayoutNode(nodeview8, 0, null);
        View<CyNode> nodeview9 = netView.getNodeView(Fumarate);
        LayoutNode thelayoutnode9 = new LayoutNode(nodeview9, 0, null);
        View<CyNode> nodeview10 = netView.getNodeView( S_malate);
        LayoutNode thelayoutnode10 = new LayoutNode(nodeview10, 0, null);

		thelayoutnode.setLocation(0,-150);
		thelayoutnode.moveToLocation();
		thelayoutnode2.setLocation(70,-100);
		thelayoutnode2.moveToLocation();
		thelayoutnode3.setLocation(100,0);
		thelayoutnode3.moveToLocation();
		thelayoutnode4.setLocation(70,100);
		thelayoutnode4.moveToLocation();
		thelayoutnode5.setLocation(20,130);
		thelayoutnode5.moveToLocation();
		thelayoutnode6.setLocation(-20,130);
		thelayoutnode6.moveToLocation();
		thelayoutnode7.setLocation(-70,100);
		thelayoutnode7.moveToLocation();
		//thelayoutnode8.setLocation(-100,60);
		//thelayoutnode8.moveToLocation();
		thelayoutnode9.setLocation(-100,0);
		thelayoutnode9.moveToLocation();
		thelayoutnode10.setLocation(-70,-100);
		thelayoutnode10.moveToLocation();

		boolean destroyNetwork = false;
		if (destroyNetwork){
			// Destroy it
			 netMgr.destroyNetwork(myNet);			
		}
	}

}


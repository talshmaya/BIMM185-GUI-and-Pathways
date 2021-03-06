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


public class PlotGlycolysis extends AbstractTask {
	
	private final CyNetworkManager netMgr;
	private final CyNetworkFactory cnf;
	private final CyNetworkNaming namingUtil; 
	private final CyEventHelper eventHelper;
	private CyNetworkViewFactory netViewFactory;
	private CyNetworkViewManager netViewMgr;
	private CyNetworkView netView; 



	public PlotGlycolysis(final CyNetworkManager netMgr, final CyNetworkNaming namingUtil,final CyNetworkFactory cnf,final CyEventHelper eventHelper,CyNetworkViewFactory netViewFactory,
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
				      namingUtil.getSuggestedNetworkTitle("Glycolysis 1"));
		netMgr.addNetwork(myNet);
		CyNetworkView netView = netViewFactory.createNetworkView(myNet);
		netViewMgr.addNetworkView(netView);

		// Add two nodes to the network
		CyNode D_glucose_6_phosphate = myNet.addNode();
		CyNode D_fructose_6_phosphate = myNet.addNode();
		CyNode fructose_1_6_bisphosphate=myNet.addNode();

		CyNode D_glyceraldehyde_3_phosphate=myNet.addNode();
		CyNode dihydroxyacetone_phosphate=myNet.addNode();
		CyNode B1_3_bisphospho_D_glycerate=myNet.addNode();
		CyNode P3_phospho_D_glycerate=myNet.addNode();

		CyNode phosphoenolpyruvate=myNet.addNode();
		CyNode pyruvate=myNet.addNode();
		CyNode P2_phospho_D_glycerate=myNet.addNode();

		CyNode newNode = myNet.addNode();

		// set name for new nodes
		myNet.getDefaultNodeTable().getRow(D_glucose_6_phosphate.getSUID()).set("name", "β-D-glucose 6-phosphate");
		//myNet.getDefaultNodeTable().getRow(D_glucose_6_phosphate.getSUID()).set("ID", "12345");
		myNet.getDefaultNodeTable().getRow(D_fructose_6_phosphate.getSUID()).set("name", "D-fructose 6-phosphate");
		myNet.getDefaultNodeTable().getRow(fructose_1_6_bisphosphate.getSUID()).set("name","fructose-1,6-bisphosphate");

		myNet.getDefaultNodeTable().getRow(D_glyceraldehyde_3_phosphate.getSUID()).set("name","D-glyceraldehyde 3-phosphate");
		myNet.getDefaultNodeTable().getRow(dihydroxyacetone_phosphate.getSUID()).set("name","dihydroxyacetone phosphate");
		myNet.getDefaultNodeTable().getRow(B1_3_bisphospho_D_glycerate.getSUID()).set("name","1,3-bisphospho-D-glycerate");
		myNet.getDefaultNodeTable().getRow(P3_phospho_D_glycerate.getSUID()).set("name","3-phospho-D-glycerate");

		myNet.getDefaultNodeTable().getRow(phosphoenolpyruvate.getSUID()).set("name","PhosphoenolPyruvate");
		myNet.getDefaultNodeTable().getRow(pyruvate.getSUID()).set("name","Pyruvate");
		myNet.getDefaultNodeTable().getRow(P2_phospho_D_glycerate.getSUID()).set("name","2-phospho-D-glycerate");

		// Add an edge
		myNet.addEdge(D_glucose_6_phosphate, D_fructose_6_phosphate,true);
		myNet.addEdge(D_fructose_6_phosphate, fructose_1_6_bisphosphate,false);
		myNet.addEdge(fructose_1_6_bisphosphate,D_glyceraldehyde_3_phosphate,false);
		myNet.addEdge(fructose_1_6_bisphosphate,dihydroxyacetone_phosphate,false);
		myNet.addEdge(D_glyceraldehyde_3_phosphate,B1_3_bisphospho_D_glycerate,true);
		myNet.addEdge(B1_3_bisphospho_D_glycerate, P3_phospho_D_glycerate,true);
		myNet.addEdge(dihydroxyacetone_phosphate, D_glyceraldehyde_3_phosphate,true);

		myNet.addEdge(P2_phospho_D_glycerate,phosphoenolpyruvate,true);
		myNet.addEdge(P3_phospho_D_glycerate, P2_phospho_D_glycerate,true);
		myNet.addEdge(phosphoenolpyruvate, pyruvate,true);
		myNet.addEdge(pyruvate,phosphoenolpyruvate, true);
		
		eventHelper.flushPayloadEvents();
		netViewMgr.addNetworkView(netView);
		View<CyNode> nodeview = netView.getNodeView(D_glucose_6_phosphate);
        LayoutNode thelayoutnode = new LayoutNode(nodeview, 0, null);
        View<CyNode> nodeview2 = netView.getNodeView(D_fructose_6_phosphate);
        LayoutNode thelayoutnode2 = new LayoutNode(nodeview2, 0, null);
        View<CyNode> nodeview3 = netView.getNodeView(fructose_1_6_bisphosphate);
        LayoutNode thelayoutnode3 = new LayoutNode(nodeview3, 0, null);
        View<CyNode> nodeview4 = netView.getNodeView(D_glyceraldehyde_3_phosphate);
        LayoutNode thelayoutnode4 = new LayoutNode(nodeview4, 0, null);
        View<CyNode> nodeview5 = netView.getNodeView(dihydroxyacetone_phosphate);
        LayoutNode thelayoutnode5 = new LayoutNode(nodeview5, 0, null);
        View<CyNode> nodeview6 = netView.getNodeView(B1_3_bisphospho_D_glycerate);
        LayoutNode thelayoutnode6 = new LayoutNode(nodeview6, 0, null);
        View<CyNode> nodeview7 = netView.getNodeView(P3_phospho_D_glycerate);
        LayoutNode thelayoutnode7 = new LayoutNode(nodeview7, 0, null);
        View<CyNode> nodeview8 = netView.getNodeView(P2_phospho_D_glycerate);
        LayoutNode thelayoutnode8 = new LayoutNode(nodeview8, 0, null);
        View<CyNode> nodeview9 = netView.getNodeView(phosphoenolpyruvate);
        LayoutNode thelayoutnode9 = new LayoutNode(nodeview9, 0, null);
        View<CyNode> nodeview10 = netView.getNodeView(pyruvate);
        LayoutNode thelayoutnode10 = new LayoutNode(nodeview10, 0, null);

		thelayoutnode.setLocation(0,-170);
		thelayoutnode.moveToLocation();
		thelayoutnode2.setLocation(0,-120);
		thelayoutnode2.moveToLocation();
		thelayoutnode3.setLocation(0,-70);
		thelayoutnode3.moveToLocation();
		thelayoutnode4.setLocation(-60,-50);
		thelayoutnode4.moveToLocation();
		thelayoutnode5.setLocation(60,-50);
		thelayoutnode5.moveToLocation();
		thelayoutnode6.setLocation(-70,0);
		thelayoutnode6.moveToLocation();
		thelayoutnode7.setLocation(-100,40);
		thelayoutnode7.moveToLocation();
		thelayoutnode8.setLocation(-120,80);
		thelayoutnode8.moveToLocation();
		thelayoutnode9.setLocation(-140,120);
		thelayoutnode9.moveToLocation();
		thelayoutnode10.setLocation(0,140);
		thelayoutnode10.moveToLocation();

		boolean destroyNetwork = false;
		if (destroyNetwork){
			// Destroy it
			 netMgr.destroyNetwork(myNet);			
		}
	}

}


BIMM185-GUI-and-Pathways
========================

Cytoscape App's GUI and Plotting Pathways Manually

Those three apps allows the user to plot three main Maize pathways: Glycolysis I, TCA cycle, and 
photosynthesis (C4 photosynthetic carbon assimilation cycle, NADP-ME type) in addition to adding a control canel and
creating table to add information to pathways. 
The three other classes (that will generate 3 jar files/3 apps) are each a bundle app. In order to generate the working 
jar file, the requirements are JDK 6 or 7 and Maven 3.X. To generate the app, navigate to the directory where the 
pom.xml file is (for example, Create-Pathways) and run the command: mvn install. This should generate the jar file 
inside the "target" directory. 
The jar file will be generated. It can be used in Cytoscape 3 by selecting Apps->App Manager from the menu. 
On the dialog, click the button Install from File. Then nevigate to the "target" directory and select Create-Pathways.jar 
and can now test the app by going to the Apps menu and choosing Maize App->Plot Pathways or any other app out of the three. 

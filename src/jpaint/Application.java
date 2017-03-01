package jpaint;


public class Application {
    private ViewMainFrame mainFrame;
    private ModelDrawingPanel modelDrawingPanel;
    public Application() {
        modelDrawingPanel = new ModelDrawingPanel();
    }
    
    public void main(){
        mainFrame = new ViewMainFrame(this);
    }

    public ViewMainFrame getMainFrame() {
        return mainFrame;
    }

    public void setMainFrame(ViewMainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public ModelDrawingPanel getModelDrawingPanel() {
        return modelDrawingPanel;
    }

    public void setModelDrawingPanel(ModelDrawingPanel modelDrawingPanel) {
        this.modelDrawingPanel = modelDrawingPanel;
    }
    
    
}

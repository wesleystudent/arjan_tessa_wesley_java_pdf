package sample;

public class ImgPreset implements IPreset{
    @Override
    public String SetExtension() {
        return "*.jpg";
    }

    @Override
    public String SetExtensionName() {
        return "Image Files";
    }

    @Override
    public void SetViewerSettings() {

    }
}

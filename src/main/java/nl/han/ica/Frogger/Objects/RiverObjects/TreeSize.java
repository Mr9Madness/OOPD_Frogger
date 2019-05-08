package nl.han.ica.Frogger.Objects.RiverObjects;

public enum TreeSize
{
    Big("src/main/assets/obstacles/Tree.png"),
    Medium("src/main/assets/obstacles/MiddleTree.png"),
    Small("src/main/assets/obstacles/LittleTree.png");

    String spritePath;

    TreeSize(String spritePath) {
    this.spritePath= spritePath;
    }
    public String getSpritePath() {
        return spritePath;
    }
}

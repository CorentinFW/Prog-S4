package TD3.file_attente;

import TD3.preambule.IFile;

public class Personne implements IFile {
    @Override
    public boolean isInvite() {
        return false;
    }
}

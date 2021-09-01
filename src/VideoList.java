import java.util.ArrayList;

public class VideoList implements MyIterator {
    private ArrayList<Video> theList;
    int currentVideo = 0;

    public VideoList() {
        this.theList = new ArrayList<Video>();
    }

    public ArrayList<Video> getList() {
        return this.theList;
    }

    public Video getVideo(String id) {
        for (int i = 0; i < this.theList.size(); i++) {
            Video temp = this.theList.get(i);
            if (temp.getID().equals(id))
                return temp;
        }
        System.out.println("Video " + id + " not found");
        return null;
    }

    public boolean addVideo(Video vid) {
        for (int i = 0; i < this.theList.size(); i++) {
            Video temp = this.theList.get(i);
            if (temp.getID().equals(vid.getID()))
                return false;
        }
        theList.add(vid);
        return true;
    }

	@Override
	public boolean hasNext() {
		if(currentVideo >= theList.size()){
			currentVideo = 0;
			return false;
		}
		return true;
	}

	@Override
	public Object next() {
		return theList.get(currentVideo++);
	}
}

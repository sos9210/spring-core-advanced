package hello.advanced.trace;

import java.util.UUID;

public class TraceId {
    private String id;
    private int level;

    public TraceId() {
        this.id = createId();
        this.level = 0;
    }

    private TraceId(String id, int level) {
        this.id = id;
        this.level = level;
    }

    private String createId() {
        return UUID.randomUUID().toString().substring(0,8);
    }
    //TraceId는 값객체이기 때문에 불변객체이므로 값이 변경되면 새로운 객체를 생성해서 반환해준다.
    public TraceId createNextId() {
        return new TraceId(id,level+1);
    }

    public TraceId createPreviousId() {
        return new TraceId(id,level-1);
    }

    public boolean isFirstLevel() {
        return level == 0;
    }

    public String getId() {
        return id;
    }

    public int getLevel() {
        return level;
    }
}

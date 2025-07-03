package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analyze {

    public static Info diff(Set<User> previous, Set<User> current) {
        Map<Integer, User> previousMap = new HashMap<>();
        for (User user : previous) {
            previousMap.put(user.getId(), user);
        }
        int added = 0;
        int changed = 0;
        for (User curr : current) {
            User prev = previousMap.get(curr.getId());
            if (prev == null) {
                added++;
            } else if (!prev.equals(curr)) {
                changed++;
            }
        }
        int deleted = previous.size() - current.size() + added;
        return new Info(added, changed, deleted);
    }

}

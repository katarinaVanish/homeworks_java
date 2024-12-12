package org.knit.additional;

import java.util.HashSet;
import java.util.Set;

public class EventAnalysis {
    public static void main(String[] args) {
        Set<String> sportsParticipants = Set.of("Alice", "Bob", "Charlie");
        Set<String> musicParticipants = Set.of("Bob", "Dave", "Eve");

        // 1. Объединение множеств
        Set<String> union = new HashSet<>(sportsParticipants);
        union.addAll(musicParticipants);
        System.out.println("Участники хотя бы одного мероприятия: " + union);

        // 2. Пересечение множеств
        Set<String> intersection = new HashSet<>(sportsParticipants);
        intersection.retainAll(musicParticipants);
        System.out.println("Участники обоих мероприятий: " + intersection);

        // 3. Участники только спортивного мероприятия
        Set<String> onlySports = new HashSet<>(sportsParticipants);
        onlySports.removeAll(musicParticipants);
        System.out.println("Участники только спортивного мероприятия: " + onlySports);

        // 4. Участники только музыкального мероприятия
        Set<String> onlyMusic = new HashSet<>(musicParticipants);
        onlyMusic.removeAll(sportsParticipants);
        System.out.println("Участники только музыкального мероприятия: " + onlyMusic);
    }
}

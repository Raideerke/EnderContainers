package fr.utarwyn.endercontainers.backup;

import org.junit.Test;

import java.sql.Timestamp;

import static org.assertj.core.api.Assertions.assertThat;

public class BackupTest {

    @Test
    public void testBackupCreation() {
        String name = "test";
        Timestamp date = new Timestamp(1);
        String type = "all";
        String createdBy = "Utarwyn";

        Backup backup = new Backup(name, date, type, createdBy);

        assertThat(backup.getName()).isEqualTo(name);
        assertThat(backup.getDate()).isEqualTo(date);
        assertThat(backup.getType()).isEqualTo(type);
        assertThat(backup.getCreatedBy()).isEqualTo(createdBy);
    }

}

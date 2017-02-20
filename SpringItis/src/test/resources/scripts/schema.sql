CREATE TABLE group_member (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(20),
  age INT
);

CREATE TABLE auto (
  id INT AUTO_INCREMENT PRIMARY KEY,
  model VARCHAR(20),
  member_id INT
);

ALTER TABLE auto ADD FOREIGN KEY (member_id) REFERENCES group_member(id);
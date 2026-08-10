INSERT INTO passage (text)
SELECT 'The quick brown fox jumps over the lazy dog.'
WHERE NOT EXISTS (SELECT 1 FROM passage WHERE text = 'The quick brown fox jumps over the lazy dog.');

INSERT INTO passage (text)
SELECT 'Practice makes progress, not perfection.'
WHERE NOT EXISTS (SELECT 1 FROM passage WHERE text = 'Practice makes progress, not perfection.');

INSERT INTO passage (text)
SELECT 'Consistency beats intensity when building a new habit.'
WHERE NOT EXISTS (SELECT 1 FROM passage WHERE text = 'Consistency beats intensity when building a new habit.');
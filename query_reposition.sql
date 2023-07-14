SELECT tb_belonging.* , tb_game.title
FROM tb_belonging
INNER JOIN tb_game
ON tb_game.id = tb_belonging.game_id
WHERE game_list_id =2
ORDER BY POSITION
#!/bin/bash

PROJECT_ID=17
COMMIT_ID=60d80027
URL=http://gitlab.matsuo.pl/api/v3/projects/$PROJECT_ID/repository/commits/$COMMIT_ID/comments

echo $URL

curl --data $'note=This is the content of comment' \
    -H "PRIVATE-TOKEN: $USER_PRIVATE_TOKEN" \
    $URL 

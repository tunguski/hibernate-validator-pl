#!/bin/bash

# CI_PROJECT_ID

HOST=http://gitlab.matsuo.pl

PROJECT_ID=$(curl -H "PRIVATE-TOKEN: $USER_PRIVATE_TOKEN" $HOST/ci/api/v1/projects | python -m json.tool | grep -E "gitlab_id|\"id\"" | grep "id\": $CI_PROJECT_ID," -B 1 | grep "\"gitlab_id\"" | cut -d ":" -f 2 | cut -d "," -f 1 | sed -e 's/^[[:space:]]*//')
COMMIT_ID=$CI_BUILD_REF




URL=$HOST/api/v3/projects/$PROJECT_ID/repository/commits/$COMMIT_ID/comments

echo $URL

curl --data $'note=This is the content of comment' \
    -H "PRIVATE-TOKEN: $USER_PRIVATE_TOKEN" \
    $URL 

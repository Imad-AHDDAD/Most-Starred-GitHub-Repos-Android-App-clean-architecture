# Most Starred Github Repositories | Android App - Clean Architecture

## Idea of the App 
a small app that lists the most starred Github repos that were created in the last 30 days. 

## Features
* the user is able to list the most starred Github repos that were created in the last 30 days. 
* the user can see the results as a list. One repository per row. 
* the user is able to see for each repo/row the following details :
  * Repository name
  * Repository description 
  * Numbers of stars for the repo. 
  * Username and avatar of the owner. 
* the user can change the order of sorted repositories (ascending or descending)

## How i got the data from Github 
To get the most starred Github repos created in the last 30 days , i used the following endpoint : 

`https://api.github.com/search/repositories?q=created:>2017-10-22&sort=stars&order=desc`

The JSON data from Github is paginated (you'll receive around 100 repos per JSON page). 

You can read more about the Github API over [here](https://developer.github.com/v3/search/#search-repositories).

## Mockups

<img src="https://github.com/Imad-AHDDAD/Most-Starred-GitHub-Repos-Android-App-clean-architecture/assets/103340643/cf48d66c-9e28-411e-8ee1-9cd637bbae40" width="377" />

<img src="https://github.com/Imad-AHDDAD/Most-Starred-GitHub-Repos-Android-App-clean-architecture/assets/103340643/9ad83570-be32-425b-a7b7-1e8f81d1503c" width="377" />

## Used technologies
* Kotlin
* Xml

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
* the user can can navigate to each repo on github by clicking on it
* the user can change application's language (fr or en)
* the user can change aplication's display mode (light or dark)

## How i got the data from Github 
To get the most starred Github repos created in the last 30 days , i used the following endpoint : 

`https://api.github.com/search/repositories?q=created:>2017-10-22&sort=stars&order=desc`

The JSON data from Github is paginated (you'll receive around 100 repos per JSON page). 

You can read more about the Github API over [here](https://developer.github.com/v3/search/#search-repositories).

## Mockups

### Light Mode

<img src="https://github.com/Imad-AHDDAD/Most-Starred-GitHub-Repos-Android-App-clean-architecture/assets/103340643/ce6757e2-6e98-4f3c-89ed-4dc80204523b" width="377" />

<img src="https://github.com/Imad-AHDDAD/Most-Starred-GitHub-Repos-Android-App-clean-architecture/assets/103340643/a80cee73-c068-4074-892b-39e5ccc35e86" width="377" />

<img src="https://github.com/Imad-AHDDAD/Most-Starred-GitHub-Repos-Android-App-clean-architecture/assets/103340643/891c1ccc-56d7-459a-9f07-43d26b74f9db" width="377" />

<img src="https://github.com/Imad-AHDDAD/Most-Starred-GitHub-Repos-Android-App-clean-architecture/assets/103340643/193411c2-9eeb-4d72-bc13-ca87b66ed8dd" width="377" />

### Dark Mode

<img src="https://github.com/Imad-AHDDAD/Most-Starred-GitHub-Repos-Android-App-clean-architecture/assets/103340643/2bb0798f-cc96-4af5-9612-a4559bd0bc24" width="377" />

<img src="https://github.com/Imad-AHDDAD/Most-Starred-GitHub-Repos-Android-App-clean-architecture/assets/103340643/72c1b7d0-f2b6-461e-b2ec-6abaadcbfa32" width="377" />

<img src="https://github.com/Imad-AHDDAD/Most-Starred-GitHub-Repos-Android-App-clean-architecture/assets/103340643/42f7e045-240a-4abc-896e-cb5f958ae80e" width="377" />


## Used technologies
* Kotlin
* Xml

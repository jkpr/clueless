## Walkthrough (using IntelliJ) of how to:
 * fork and clone repo on Github
 * create local `develop` branch
 * Add file to git repo on IntelliJ
 * Commit and push to own Github repo
 * Make pull-request on Github
 * Add additional remote repo to git
 
 ## 0) Fork `clueless` repository
 
 - After you have your Github account created and are signed in, navigate to [github.com/jkpr/clueless](https://github.com/jkpr/clueless)
 - Fork the repo by clicking on "Fork" button on the top right corner:
![fork-clueless](https://www.dropbox.com/s/wmindt7ive5phrt/fork-clueless.jpeg?dl=1)

## 1) Clone your repo to your computer

- Once you have downloaded and installed [IntelliJ](http://www.jetbrains.com/idea/), at the Welcome dialog box you'll have a choice of how to start a project
- Select _Github_ from the drop-down list ("Check out from Version Control")
- Click _Create API Token_ so your Github credentials aren't saved by IntelliJ
- Type your Github username and password to create the token
- Click _Login_ twice to close the dialog boxes:
![create-github-intellij-token](https://www.dropbox.com/s/i2vlnn6d4hruq6c/create-github-intellij-token.png?dl=1)

- From the drop-down list, locate the `clueless.git` repo from your Github account
- After you choose the Parent Directory for the local repo/project, click _Clone_
![clone-github-repo-intellij](https://www.dropbox.com/s/sow1m9k09bpui1f/clone-github-repo-intellij.png?dl=1)

- Click _Yes_ to create the IntelliJ project out of the repo
![create-project](https://www.dropbox.com/s/k46s3htxvkuiwg8/create-project.png?dl=1)

- Click _Next_:
![create-project-next](https://www.dropbox.com/s/y8eyurtfe61v506/create-project-next.png?dl=1)

- Click _Next_:
![create-project--name-next](https://www.dropbox.com/s/y0rbify9gz1gvmi/create-project--name-next.png?dl=1)

- Click _Next_:
![create-project-source-files-next](https://www.dropbox.com/s/shaumisd4cc91o8/create-project-source-files-next.png?dl=1)

- Click _Finish_:
![create-project-finish](https://www.dropbox.com/s/6zmwaojl10fyyno/create-project-finish.png?dl=1)

- Your Project should get created from the clone of your fork, and you're now set to begin making contributions.

## 2) Switch to `develop` branch

- You're currently on the Master branch
- On the bottom right corner of IntelliJ, click on _Git: master_
- Then click on _origin/develop_ (this is the fetched branch from your Github repo, called "origin")
- Then click on _Checkout as new local branch_ (In order to be able to switch to the new branch, this merges, into your working directory, the branch that you fetched into your local repo  when you cloned the repo)
![switch-local-develop](https://www.dropbox.com/s/703d06u2ymtv3by/switch-local-develop.png?dl=1)


- Click _OK_
![develop-ok](https://www.dropbox.com/s/u22ogv9jd97rtaa/develop-ok.png?dl=1)

- Notice the notification and status bar, along with the Git drop-down list, indicating the switch to `develop`
![develop-notice](https://www.dropbox.com/s/ptm6zbwig79ixdg/develop-notice.png?dl=1)

## 3) Add some text (possibly README, possibly into "devdocs" folder)

- Right-click on a folder in the 1:Project window > New > File (You may want to name it with the _.md_ file extension, so you can format the text using markdown)
- Click _Yes_ to add the file into the Git staging area. This ensures that the file will be commited so that it can be in version control
![Add-file-git](https://www.dropbox.com/s/cekwnl0btg6200e/add-file-git.png?dl=1)

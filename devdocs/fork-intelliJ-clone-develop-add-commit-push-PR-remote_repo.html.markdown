## Walkthrough (using IntelliJ) of how to:
 * fork and clone repo on Github
 * create local `develop` branch
 * Add file to git repo on IntelliJ
 * Commit and push to own Github repo
 * Make pull-request on Github
 * Add additional remote repo to git


## 0) Fork `clueless` repository:
 
 - After you have your Github account created and are signed in, navigate to [github.com/jkpr/clueless](https://github.com/jkpr/clueless)
 - Fork the repo by clicking on the "Fork" button on the top right corner:
![fork-clueless](https://www.dropbox.com/s/wmindt7ive5phrt/fork-clueless.jpeg?dl=1)

## 1) Clone your repo to your computer:

- Once you have downloaded and installed [IntelliJ](http://www.jetbrains.com/idea/), at the Welcome dialog box you'll have a choice of how to start a project
- 1.) Select _Github_ from the drop-down list ("Check out from Version Control")
- 2.) Click _Create API Token_ so your Github credentials aren't saved by IntelliJ
- 3.) Type your Github username and password to create the token
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

## 2) Switch to `develop` branch:

- You're currently on the Master branch
- On the bottom right corner of IntelliJ, click on _Git: master_
- Then click on _origin/develop_ (this is the fetched branch from your Github repo, called "origin")
- Then click on _Checkout as new local branch._ (In order to be able to switch to the new branch, this merges, into your working directory, the branch that you fetched into your local repo  when you cloned the repo)
![switch-local-develop](https://www.dropbox.com/s/703d06u2ymtv3by/switch-local-develop.png?dl=1)


- Click _OK_
![develop-ok](https://www.dropbox.com/s/u22ogv9jd97rtaa/develop-ok.png?dl=1)

- Notice the notification and status bar, along with the Git drop-down list, indicating the switch to `develop`
![develop-notice](https://www.dropbox.com/s/ptm6zbwig79ixdg/develop-notice.png?dl=1)

## 3) Add some text (possibly README, possibly into "devdocs" folder):

- Right-click on a folder in the _1:Project_ window > _New_ > _File_ (You may want to name it with the _.md_ file extension, so you can format the text using markdown)
- Click _Yes_ to add the file into the Git staging area. This ensures that the file will be commited so that it can be in version control
![Add-file-git](https://www.dropbox.com/s/cekwnl0btg6200e/add-file-git.png?dl=1)

## 4) Commit and 5) Push to your repository:

- 1.) Open the _9: Version Control_ window
- 2.) Click the _VCS_ button to open the _Commit Changes_ dialog box
- 3.) Modify the _Commit Message_ describing what you changed, but in present tense
- 4.) Always check the _Diff,_ showing the difference between this commit and the last
- 5.) I prefer the _Unified viewer_
- 6.) and I prefer to _Highlight split changes_
- 7.) Finally, you can choose to immediately push the commit to your Github repo. Otherwise, just choose _Commit_
![diff-commit-push](https://www.dropbox.com/s/6mlm5b8ygsqu0qz/diff-commit-push.png?dl=1)

- Notice the notification and status bar message indicating the successful commit
- Verify that you are pushing the local `develop` branch to your Github repo's `develop` branch and click _Push_
![commit-notice-push](https://www.dropbox.com/s/otptz3bmtq6vwlk/commit-notice-push.png?dl=1)

- Notice the notification and status bar message indicating the successful push
![push-notice-successful](https://www.dropbox.com/s/s76re65mzx0olil/push-notice-successful.png?dl=1)

## 6) Make pull request to base (upstream) repository with Github

- Navigate to the _Pull requests_ tab in your forked repo of `clueless`
- Click on the _New pull request_ button
![start-pull-request](https://www.dropbox.com/s/qno9p6exbg0b5cj/start-pull-request.png?dl=1)

- You'll now configure and compare your changes with the base repo
- 1.) Make sure the base repo is set to the `develop` branch
- 2.) Make sure your repo is set to the `develop` branch
- 3.) Verify that the branches are "Able to merge"
- 4.) In reviewing the changes before making the PR, I prefer _Unified_ 
- 5.) and to _Display the rich diff._ You can play around with these settings to find what you prefer
- 6.) After reviewing, click _Create pull request_
![compare-changes](https://www.dropbox.com/s/uw9s6w1ju47w3xj/compare-changes.png?dl=1)

- 1.) Write a descriptive title for the PR
- 2.) Start the conversation that may be necessary before the PR is accepted. Mention others with the @ symbol
- 3.) Make sure _Allow edits from maintainers_ is checked so that time doesn't have to be wasted asking you to make minor edits. The base repo maintainer can make them and go ahead and accept the PR
- 4.) Click _Create pull request_
![describe-pull-request](https://www.dropbox.com/s/oau5ulu2ee00drf/describe-pull-request.png?dl=1)

- If you successfully made the pull-request, you'll see that it is Open, the number in the _Pull requests_ tab will have increased by 1, and there will be a PR number after your PR title.
- On this page, as you return to it, you can continue the conversation, you can edit the PR, edit a comment, or compare the changes again, make additional comments to a modified line, or start a code review by clicking on the _Files changed_ tab
![successful-open-PR](https://www.dropbox.com/s/12fjqtg2xi69e8c/successful-open-pr.png?dl=1)

## 7) Add @jkpr (upstream) repository as a remote so that you can pull code from there directly to your computer

- Adding the upstream remote will allow you to Fast-Forward or merge to the latest code changes in the base repo
- 1.) From the base repo github page, you can retrieve the necessary url
- 2.) Click on the _Clone or Download_ drop-down button
- 3.) Click on the clipboard icon to copy the url to your clipboard
![retrieve-upstream-url](https://www.dropbox.com/s/kav4evhyan4pf24/retrieve-upstream-url.png?dl=1)

- 1.) Back in IntelliJ, open a _Terminal_ session (Most of what has been done in all the steps above are normally done within a terminal)
- 2.) Enter the following command to check the current remote urls: `git remote -v`
- 3.) Add the base repo url and call it _upstream:_ `git remote add upstream ` followed by your copied base repo url
- 4.) Verify that it was added with the same command as in 2.). Use the up arrow key to avoid retypng it
![upstream-remote](https://www.dropbox.com/s/nio6fx6z2grw5c4/upstream-remote.png?dl=1)
 
# That's it!
We can cover how to actually Fast-Forward branches or sync forks later, as needed. Or _you_ can add to this file explaining it yourself!
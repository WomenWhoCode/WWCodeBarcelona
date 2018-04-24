# Branches

Every project has a `master` branch where all the code resides, that is the core of the content in the repository. But when you are working with a team is dangerous and hard to [commit](Commit_Push_Pull.md#Commit) straight to master since you are all working from the same code.

Imagine you are tasked to add an address to a User.txt file, and your colleague has to add the user birthday also on the same file. If you both [Pull](Commit_Push_Pull.md#Pull) from master and do your changes and then commit Github will complain once you both try to [push](Commit_Push_Pull.md#Push) you changes to the repository.

That is because it will not know which version of the changes to choose. If your colleague has pushed their changes ahead of you, Github will let you know that your file is out of date with master and thus not accept your push until you pull. You could do that but then what happens if you colleague introduced a bug on his commit? Now no one can keep working until it is finished.

That is not a good workflow. Branches exist to solve this problem.

Before you start working on an assignment you pull the latest from master and use that content to create your own branch to do all your work.

![Branches](../assets/branches.png)

## New Branch

`git checkout -b "branchName"`

## Existing branch

`git checkout "branchName"`

## Integrating changes from one branch to another

There are 2 main ways to integrate changes from one branch to another: `merge` and `rebase`

### Merging

Merging records the commits prioritizing the time.
More information at [git](https://git-scm.com/docs/git-merge)

### Rebasing

This command allows to take all the changes that were commited on one branch and replay them on another one.
More information at [git](https://git-scm.com/docs/git-rebase)

### Merge vs Rebase

Merge's point of view os that your repository's commit history is a record of what actually happened while rebase's point of view is that the commit history is the story of how your project was made.

It’s up to you to decide which one is best for your particular situation.

In general the way to get the best of both worlds is to rebase local changes you’ve made but haven’t shared yet before you push them in order to clean up your story, but never rebase anything you’ve pushed somewhere.
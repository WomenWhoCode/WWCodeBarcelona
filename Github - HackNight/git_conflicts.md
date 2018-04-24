# Instructions to create conflicts

There are several types of conflicts. Merge conflics, rebase conflicts...
It happens because git is confused and needs help to make the right decision

## How to avoid conflicts

Some recomendations to avoid conflicts:

- Use branches
- Sync from remote often (with `git fetch <remote>`)
- Rebase before pushing anything (with `git rebase branch`)

## How to create conflicts

It's helpful when you know why you have conflicts and how to solve them
Like bugs, try to keep them small.
Git works with hashes when there're 2 different hash values in the same section of a file, git doesn't know which is the correct one. When happens, Git requieres help from the developer, you, to decide which is the good one.
You tell git, git is happy and keeps on doing his job.

## When conflicts shows up

Git will tell you when you have files modified twice with a message like the following

```bash
git status
# On branch branchName
# You have unmerged paths.
#   (fix conflicts and run "git commit")
#
# Unmerged paths:
#   (use "git add ..." to mark resolution)
#
# both modified:      somefile
#
no changes added to commit (use "git add" and/or "git commit -a")
```

### Create Merge conflict

- Create a branch from `master` called `origin_of_conflicts`
- Checkout this branch again with a different name (with `git checkout -b "new_conflict"`)
- At `origin_of_conflicts`, edit section `XXX` of this file
- Commit this change (with `git commit -am "Changes on section XXX"`)
- Push the change to remote (with `git push <remote> origin_of_conflicts`)
- From `new_conflict`, change a line from the same section
- Commit this change
- Push the change to remote

## How to solve the conflict

Open your favorite text editor and navigate to the file that has merge conflicts.

To see the beginning of the merge conflict in your file, search the file for the conflict marker `<<<<<<<`. When you open the file in your text editor, you'll see the changes from the HEAD or base branch after the line `<<<<<<< HEAD`. Next, you'll see `=======`, which divides your changes from the changes in the other branch, followed by `>>>>>>> BranchName`

Decide if you want to keep only your branch's changes, keep only the other branch's changes, or make a brand new change, which may incorporate changes from both branches. Delete the conflict markers `<<<<<<<`, `=======`, `>>>>>>>` and make the changes you want in the final merge

add or stage your changes

Commit your changes with a comment
<h1>
    EcoNex
</h1>

### Installation Guide

1. Clone this repository by running the following in a terminal / Use Github Desktop.
```sh
git clone https://github.com/abbyspeed/EcoNex.git .
```
2. Change to your branch,
```sh
// check available branches
$ git branch -r

// switch to your branch
$ git checkout branch_name
```

I have already created some branches for you. You can see the list of branches from the repository page on the dropdown menu ![](https://github.com/SadmanYasar/student-practical-training-system/assets/67522140/935218a9-5b1b-44ce-9635-c615daee598c)

### Rules You Must Follow
1. Don't push to main branch directly.
2. Work only on your branch.
3. Then create a pull request to merge your branch with main branch.
4. Check your current branch before developing and pushing to remote.
```sh
// check current branch
$ git branch
```
5. Notify others then they can review your code and merge it with main branch.

### Important Notes
- If you create a new controller, you must add the package name to [base-package](https://github.com/abbyspeed/EcoNex/blob/fef39656ac5bf3578be4e5876a83fb8095a3c7bf/WebContent/WEB-INF/NexCode-servlet.xml#L13). Separate previous package names with comma.

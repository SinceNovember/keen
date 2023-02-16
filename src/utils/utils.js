export function changeHtmlVal(name, value) {
    window.document.documentElement.setAttribute(name, value)
}

export function changeElementVal(name, value) {
    window.document.body.setAttribute(name, value)
}


export function addElementCls(cls) {
    window.document.body.classList.add(cls)
}

export function removeElementCls(cls) {
    window.document.body.classList.remove(cls)
}

export function hasShowingChild(children = [], parent) {
    // if (parent.component.name != "Layout") {
    //     return false;
    // }
    const showingChildren = children.filter(item => {
        if (item.hidden) {
            return false;
        } else {
            // Temp set(will be used if only has one showing child)
            // this.onlyOneChild = item;
            return true;
        }
    })

    // When there is only one child router, the child router is displayed by default
    if (showingChildren.length > 0) {
        return true;
    }

    // Show parent if there are no child router to display
    // if (showingChildren.length === 0) {
    //     this.onlyOneChild = { ...parent, path: "", noShowingChildren: true };
    //     return true;
    // }

    return false;
}

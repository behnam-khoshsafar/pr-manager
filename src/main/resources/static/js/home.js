function handleError(jqXhr) {
    if (jqXhr.status === 401) {
        alert("Authorization Failed");
        logout();
    } else {
        const message = jqXhr.responseJSON != null ? jqXhr.responseJSON.message : '';
        alert("Failed: " + message);
    }
}

$.ajax("/user", {
    success: function (data, status, xhr) {
        $("#user").html(data.name);
        $(".unauthenticated").hide()
        $(".authenticated").show()
    },
    error: function (jqXhr, textStatus, errorMessage) {
        handleError(jqXhr);
    }
});

const logout = function () {
    $.post("/logout", function () {
        $("#user").html('');
        $(".unauthenticated").show();
        $(".authenticated").hide();
    })
    return true;
};

function getThead() {
    return document.createElement('thead');
}

function getTBody() {
    return document.createElement('tbody');
}

function getRaw() {
    return document.createElement('tr');
}

function getTHeaderElement(value) {
    let element = document.createElement('th');
    element.innerHTML = value;
    return element;
}

function getTDataElement(value) {
    let element = document.createElement('td');
    element.innerHTML = value;
    return element;
}

function createTable(thead, tbody) {
    let table = document.createElement('table');
    table.appendChild(thead);
    table.appendChild(tbody);
    table.classList.add("table");
    table.classList.add("table-bordered");
    table.classList.add("table-striped");
    return table;
}

const getRepositories = function () {
    function createRepository(data) {
        let thead = getThead();
        let tbody = getTBody();

        let headerRow = getRaw();
        headerRow.appendChild(getTHeaderElement("ID"));
        headerRow.appendChild(getTHeaderElement("Name"));
        headerRow.appendChild(getTHeaderElement("Owner"));
        thead.appendChild(headerRow);

        function createNameElement(repo) {
            let name = document.createElement('td');
            let newlink = document.createElement('a');
            newlink.setAttribute('href', 'javascript:getPullRequest(\'' + repo.owner + '\',\'' + repo.name + '\')');
            newlink.innerHTML = repo.name;
            name.appendChild(newlink);
            return name;
        }

        data.forEach(repo => {
            let row = getRaw();
            row.appendChild(getTDataElement(repo.id));
            row.appendChild(createNameElement(repo));
            row.appendChild(getTDataElement(repo.owner));
            tbody.appendChild(row);
        });
        const table = createTable(thead, tbody);
        document.getElementById('repo-content-container').innerHTML = table.outerHTML;
    }

    $.ajax("/user/repos", {
        success: function (data, status, xhr) {
            createRepository(data);
        },
        error: function (jqXhr, textStatus, errorMessage) {
            handleError(jqXhr);
        }
    })
};

const getPullRequest = function (owner, repo) {
    var url = '/repos/' + owner + '/' + repo + '/pulls'

    function createPullRequest(data) {
        let thead = getThead();
        let tbody = getTBody();

        let headerRow = getRaw();

        headerRow.appendChild(getTHeaderElement("ID"));
        headerRow.appendChild(getTHeaderElement("Title"));
        headerRow.appendChild(getTHeaderElement("Owner"));
        headerRow.appendChild(getTHeaderElement("Updated-at"));
        headerRow.appendChild(getTHeaderElement("Head branch"));
        headerRow.appendChild(getTHeaderElement("Base branch"));
        headerRow.appendChild(getTHeaderElement("Reviewers"));
        headerRow.appendChild(getTHeaderElement("State"));
        thead.appendChild(headerRow);

        data.forEach(pullRequest => {
            let row = getRaw();
            row.appendChild(getTHeaderElement(pullRequest.id));
            row.appendChild(getTHeaderElement(pullRequest.title));
            row.appendChild(getTHeaderElement(pullRequest.owner));
            row.appendChild(getTHeaderElement(pullRequest.updatedAt));
            row.appendChild(getTHeaderElement(pullRequest.headBranchName));
            row.appendChild(getTHeaderElement(pullRequest.baseBranchName));
            row.appendChild(getTHeaderElement(pullRequest.reviewers));
            row.appendChild(getTHeaderElement(pullRequest.state));
            tbody.appendChild(row);
        });
        const table = createTable(thead, tbody);
        document.getElementById('pull-request-content-container').innerHTML = table.outerHTML
    }

    $.ajax(url, {
        success: function (data, status, xhr) {
            createPullRequest(data);
        },
        error: function (jqXhr, textStatus, errorMessage) {
            handleError(jqXhr);
        }
    })
}


$.ajaxSetup({
    beforeSend: function (xhr, settings) {
        if (settings.type === 'POST' ||
            settings.type === 'PUT' ||
            settings.type === 'DELETE') {
            if (!(/^http:.*/.test(settings.url) ||
                /^https:.*/.test(settings.url))) {
                // Only send the token to relative URLs i.e. locally.
                xhr.setRequestHeader("X-XSRF-TOKEN",
                    Cookies.get('XSRF-TOKEN'));
            }
        }
    }
});

$.get("/error", function (data) {
    if (data) {
        $(".error").html(data);
    } else {
        $(".error").html('');
    }
});
